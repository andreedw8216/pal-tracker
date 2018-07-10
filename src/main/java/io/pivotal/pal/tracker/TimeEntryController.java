package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepo;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepo = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {

        TimeEntry timeEntryCreate = timeEntryRepo.create(timeEntry);

        return new ResponseEntity<>(timeEntryCreate ,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id)
    {
        TimeEntry timeEntry = timeEntryRepo.find(id);
        if(timeEntry != null)
            return new ResponseEntity(timeEntry, HttpStatus.OK);
        else
            return new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list()
    {
        return new ResponseEntity(timeEntryRepo.list(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry updatedTimeEntry)
    {

        TimeEntry timeEntry = timeEntryRepo.update(id, updatedTimeEntry);
        if(timeEntry != null)
            return new ResponseEntity(timeEntry, HttpStatus.OK);
        else
            return new ResponseEntity(timeEntry, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id)
    {
        timeEntryRepo.delete(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}