package com.meetings.meetings.mappers;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.transports.MeetingTransport;

public class MeetingMapper {

    public static MeetingTransport meetingToMeetingTransport(Meeting meeting) {
        return new MeetingTransport(meeting.getId(), meeting.getTitle(), meeting.getStartTime(), meeting.getEndTime(),
                meeting.getPlace(), meeting.getDescription(), meeting.getOnline(), meeting.getMeetingStatus().toString(),
                MeetingUserMapper.meetingUserToMeetingUserTransport(meeting.getCreatedBy()),
                MeetingUserMapper.meetingUserToMeetingUserTransport(meeting.getInvitedUser()), meeting.getComment());
    }

}
