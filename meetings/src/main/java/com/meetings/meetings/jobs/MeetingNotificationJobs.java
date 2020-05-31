package com.meetings.meetings.jobs;

import com.meetings.meetings.integration.models.SerializableEmail;
import com.meetings.meetings.integration.producers.EmailProducer;
import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.services.MeetingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class MeetingNotificationJobs {

    private static final long HOUR = 60*60*1000;

    private MeetingService meetingService;
    private EmailProducer emailProducer;

    public MeetingNotificationJobs(MeetingService meetingService, EmailProducer emailProducer) {
        this.meetingService = meetingService;
        this.emailProducer = emailProducer;
    }

    @Scheduled(cron = "0 8 * * *") //every day at 8 AM
    public void notifyAboutMeetingsToday() {
        long startTimeMillis = System.currentTimeMillis();
        long endTimeMillis = startTimeMillis + 12*HOUR;
        Timestamp startTime = new Timestamp(startTimeMillis);
        Timestamp endTime = new Timestamp(endTimeMillis);
        List<Meeting> meetings = meetingService.getAllMeetingsBetween(startTime, endTime);
        for(Meeting meeting : meetings) {
            String meetingCreatorFullName = meeting.getCreatedBy().getFirstName() + " " + meeting.getCreatedBy().getLastName();
            String meetingInvitedParticipantFullName = meeting.getInvitedUser().getFirstName() + " " + meeting.getInvitedUser().getLastName();
            String meetingCreatorEmail = meeting.getCreatedBy().getEmail();
            String meetingInvitedParticipantEmail = meeting.getInvitedUser().getEmail();
            String subject = "Don't forget about your meeting today";
            String content = "Hello there\n\nThis is just a reminder about the meeting between " + meetingCreatorFullName + " and " + meetingInvitedParticipantFullName
                    + " that is going to happen at " + meeting.getStartTime().toLocalDateTime().toString() + ", with location " + meeting.getPlace() + ".\n\n" +
                    "Best regards,\n\nEducation Management System Developers";
//            emailProducer.produce(new SerializableEmail(meetingCreatorEmail, subject, content));
//            emailProducer.produce(new SerializableEmail(meetingInvitedParticipantEmail, subject, content));
        }
    }

}
