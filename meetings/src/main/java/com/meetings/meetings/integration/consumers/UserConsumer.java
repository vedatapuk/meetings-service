package com.meetings.meetings.integration.consumers;

import com.meetings.meetings.integration.models.SerializableUser;
import com.meetings.meetings.services.MeetingUserService;
import com.meetings.meetings.transports.MeetingUserTransport;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    private MeetingUserService meetingUserService;

    public UserConsumer(MeetingUserService meetingUserService) {
        this.meetingUserService = meetingUserService;
    }

    @RabbitListener(queues = {"${queue.user.new.teacher}", "${queue.user.new.parent}"})
    public void handleNewUserReception(SerializableUser user) {
        MeetingUserTransport meetingUserTransport = new MeetingUserTransport(user.getId(), user.getFirstName(), user.getLastName(),
                user.getRole(), user.getEmail());
        meetingUserService.saveMeetingUser(meetingUserTransport);
    }

}
