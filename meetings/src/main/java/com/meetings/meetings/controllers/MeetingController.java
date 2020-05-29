package com.meetings.meetings.controllers;

import com.meetings.meetings.PerRequestIdStorage;
import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.services.MeetingService;
import com.meetings.meetings.transports.MeetingListTransport;
import com.meetings.meetings.transports.MeetingTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("{id}")
    public Meeting findMeetingById(@PathVariable String id) {
        return meetingService.getMeetingById(id);
    }

    @GetMapping
    public List<Meeting> getMeetingsByUserId() {
        return meetingService.getMeetingsByUserId(PerRequestIdStorage.getUserId());
    }

    @PostMapping
    public MeetingTransport addMeeting(@RequestBody MeetingTransport meetingTransport) {
        return meetingService.saveMeeting(meetingTransport);
    }

    @PutMapping("{meetingId}")
    public MeetingTransport updateMeeting(@PathVariable String meetingId, @RequestBody MeetingTransport meetingTransport) {
        return meetingService.updateMeeting(meetingId, meetingTransport);
    }

//    @PutMapping("{meetingId}/comment")
//    public void addComment(@PathVariable String meetingId, @RequestBody MeetingTransport meetingTransport) {
//        meetingService.updateComment(meetingId, meetingTransport);
//    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{meetingId}")
    public void deleteMeeting(@PathVariable String meetingId) {
        meetingService.deleteMeeting(meetingId);
    }

}
