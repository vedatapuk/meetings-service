package com.meetings.meetings.services;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.transports.MeetingListTransport;
import com.meetings.meetings.transports.MeetingTransport;
import org.apache.logging.log4j.message.TimestampMessage;

import java.sql.Timestamp;
import java.util.List;

public interface MeetingService {

    MeetingTransport saveMeeting(MeetingTransport meetingTransport);

    Meeting getMeetingById(String id);

    List<Meeting> getMeetingsByStatus(String status);

    List<Meeting> getMeetingsByPlace(String place);

    Meeting commentToMeeting(String comment);

    void deleteMeeting(String id);

    MeetingTransport updateMeeting(String id, MeetingTransport meetingTransport);

    MeetingTransport updateComment(String meetingId, MeetingTransport meetingTransport);

    List<Meeting> getMeetingsByUserId(String userId);

    List<Meeting> getAllMeetingsBetween(Timestamp startTime, Timestamp endTime);

}
