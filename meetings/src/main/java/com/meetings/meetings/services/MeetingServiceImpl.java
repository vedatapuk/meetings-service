package com.meetings.meetings.services;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.repositories.MeetingRepo;
import com.meetings.meetings.type.MeetingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    private MeetingRepo repository;

    public Meeting saveMeeting(Meeting meeting) {
        return repository.save(meeting);
    }

    public List<Meeting> getAllMeetings() {
        return repository.findAll();
    }

    public Meeting getMeetingById(String id) {
        return repository.findById(id);
    }

    public List<Meeting> getMeetingsByStatus(String status){
        return repository.findByMeetingStatus(MeetingStatus.valueOf(status));
    }

    public List<Meeting> getMeetingsByPlace(String place) {
        return repository.findByPlace(place);
    }

    public void deleteMeeting(String id) {
        repository.deleteById(id);
    }

    public Meeting updateMeeting(String id, Meeting meeting) {
        Meeting existingMeeting = repository.findById(id);
        existingMeeting.setTitle(meeting.getTitle());
        existingMeeting.setStartTime(meeting.getStartTime());
        existingMeeting.setEndTime(meeting.getEndTime());
        existingMeeting.setPlace(meeting.getPlace());
        existingMeeting.setDescription(meeting.getDescription());
        existingMeeting.setOnline(meeting.getOnline());
        existingMeeting.setMeetingStatus(meeting.getMeetingStatus());
        return repository.save(existingMeeting);
    }


}
