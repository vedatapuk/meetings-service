package com.meetings.meetings.services;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.transports.MeetingListTransport;
import com.meetings.meetings.transports.MeetingTransport;

import java.util.List;

public interface MeetingService {

    MeetingTransport saveMeeting(Meeting meeting);

    Meeting getMeetingById(String id);

    List<Meeting> getMeetingsByStatus(String status);

    List<Meeting> getMeetingsByPlace(String place);

    Meeting commentToMeeting(String comment);

    void deleteMeeting(String id);

    MeetingTransport updateMeeting(String id, MeetingTransport meetingTransport);

    void addComment(String meetingId, MeetingTransport meetingTransport);

    MeetingListTransport getMeetingsByUserId(String userId);
}
