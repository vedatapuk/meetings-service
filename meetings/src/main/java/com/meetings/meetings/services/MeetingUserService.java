package com.meetings.meetings.services;

import com.meetings.meetings.models.MeetingUser;
import com.meetings.meetings.transports.MeetingUserTransport;

public interface MeetingUserService {

    void saveMeetingUser(MeetingUserTransport meetingUserTransport);

    MeetingUser getMeetingUserById(String id);

}
