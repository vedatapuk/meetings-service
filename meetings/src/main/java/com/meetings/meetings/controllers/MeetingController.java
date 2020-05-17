package com.meetings.meetings.controllers;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.services.MeetingService;
import com.meetings.meetings.type.MeetingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService service;

    @PostMapping("/")
    public Meeting addMeeting(@RequestBody Meeting meeting) {
        return service.saveMeeting(meeting);
    }

    @GetMapping("/{id}")
    public Meeting findMeetingById(@PathVariable String id) {
        return service.getMeetingById(id);
    }

    @GetMapping
    public List<Meeting> findMeetingsByStatus(@RequestParam("status") String status) {
        return service.getMeetingsByStatus(status);
    }

    @GetMapping("/place")
    public List<Meeting> findMeetingsByPlace(@RequestParam("place") String place) {
        return service.getMeetingsByPlace(place);
    }

    @PutMapping("/{id}")
    public Meeting updateMeeting(@PathVariable String id, @RequestBody Meeting meeting) {
        return service.updateMeeting(id, meeting);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteMeeting(@PathVariable String id) {
        service.deleteMeeting(id);
    }
}
