package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.List;

public interface TimeEntryRepository {

    HashMap<Long, TimeEntry> timeEntries = null;

    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry find(Long id);

    public List<TimeEntry> list();

    public TimeEntry update(Long id,TimeEntry timeEntry);

    public void delete(Long id);
}
