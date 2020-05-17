package com.meetings.meetings.services;

import com.meetings.meetings.models.Meeting;

import java.util.List;

public interface MeetingService {

    Meeting saveMeeting(Meeting meeting);

    Meeting getMeetingById(String id);

    List<Meeting> getMeetingsByStatus(String status);

    List<Meeting> getMeetingsByPlace(String place);

//    Meeting commentToMeeting(String comment);

    void deleteMeeting(String id);

    Meeting updateMeeting(String id, Meeting meeting);

}
