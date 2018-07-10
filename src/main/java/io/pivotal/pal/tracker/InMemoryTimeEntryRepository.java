package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long, TimeEntry> timeEntries = new HashMap<>();
    public InMemoryTimeEntryRepository() {

    }

    public TimeEntry create(TimeEntry timeEntry) {
        Long id = timeEntries.size() + 1L;

        TimeEntry newTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.put(id, newTimeEntry);

        return newTimeEntry;
    }

    public TimeEntry find(Long id) {
        return timeEntries.get(id);
    }

    public List<TimeEntry> list()
    {
        return new ArrayList<>(timeEntries.values());
    }

    public TimeEntry update(Long id,TimeEntry timeEntry) {
        TimeEntry updatedTimeEntry = new TimeEntry(id,timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.replace(id, updatedTimeEntry);
        return updatedTimeEntry;
    }

    public void delete(Long id) {
        timeEntries.remove(id);
    }
}
