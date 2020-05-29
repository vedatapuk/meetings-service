package com.meetings.meetings.mappers;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.models.MeetingUser;
import com.meetings.meetings.transports.MeetingTransport;
import com.meetings.meetings.type.MeetingStatus;

public class MeetingMapper {

    public static MeetingTransport meetingToMeetingTransport(Meeting meeting) {
        return new MeetingTransport(meeting.getId(), meeting.getTitle(), meeting.getStartTime(), meeting.getEndTime(),
                meeting.getPlace(), meeting.getDescription(), meeting.getOnline(), meeting.getMeetingStatus().toString(),
                meeting.getCreatedBy().getId(), meeting.getInvitedUser().getId(), meeting.getComment());
    }

    public static Meeting meetingTransportToMeeting(MeetingUser createdBy, MeetingUser invitedUser, MeetingTransport meetingTransport) {
        return new Meeting(meetingTransport.getTitle(), meetingTransport.getStartTime(), meetingTransport.getEndTime(), meetingTransport.getPlace(),
                meetingTransport.getDescription(), meetingTransport.isOnline(), MeetingStatus.valueOf(meetingTransport.getMeetingStatus()), createdBy,
                invitedUser, meetingTransport.getComment());
    }

}
