package io.pivotal.pal.tracker;

import ch.qos.logback.core.status.Status;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        TimeEntry entry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(entry, HttpStatus.CREATED);
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        TimeEntry entry = timeEntryRepository.find(timeEntryId);
        HttpStatus status= HttpStatus.OK;
        if (entry == null){
           status = HttpStatus.NOT_FOUND;
         }

        return new ResponseEntity<>(entry,status);
    }

    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> entries = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(entries,HttpStatus.OK);
    }

    public ResponseEntity<TimeEntry> update(long timeEntryId, TimeEntry timeEntryToUpdate) {
        return null;
    }

    public ResponseEntity<Void> delete(long timeEntryId) {
        return null;
    }
}
