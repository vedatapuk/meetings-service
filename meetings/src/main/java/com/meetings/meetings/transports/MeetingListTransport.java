package com.meetings.meetings.transports;

import com.meetings.meetings.annotations.ApiEntity;

import java.util.List;

@ApiEntity
public class MeetingListTransport {

    private List<MeetingTransport> meetingTransports;

    public MeetingListTransport(List<MeetingTransport> meetingTransports) {
        this.meetingTransports = meetingTransports;
    }

    public List<MeetingTransport> getMeetingTransports() {
        return meetingTransports;
    }

    public void setMeetingTransports(List<MeetingTransport> meetingTransports) {
        this.meetingTransports = meetingTransports;
    }

}
