package com.meetings.meetings.mappers;

import com.meetings.meetings.models.MeetingUser;
import com.meetings.meetings.transports.MeetingUserTransport;

public class MeetingUserMapper {

    public static MeetingUserTransport meetingUserToMeetingUserTransport(MeetingUser meetingUser) {
        return new MeetingUserTransport(meetingUser.getId(), meetingUser.getFirstName(), meetingUser.getLastName());
    }

}
