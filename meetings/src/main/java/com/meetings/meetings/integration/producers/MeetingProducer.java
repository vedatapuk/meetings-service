package com.meetings.meetings.integration.producers;

import com.meetings.meetings.integration.models.SerializableMeeting;
import com.meetings.meetings.models.Meeting;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MeetingProducer {

    @Value("${routing.meeting.new.online}")
    private String newOnlineMeetingRoutingKey;

    @Value("${exchange.topic}")
    private String topicExchange;

    private final RabbitTemplate rabbitTemplate;

    public MeetingProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNewMeeting(Meeting meeting) {
        SerializableMeeting serializableMeeting = new SerializableMeeting(meeting.getId(), meeting.getTitle(), meeting.getStartTime().getTime(),
                meeting.getEndTime().getTime(), meeting.getPlace(), meeting.getDescription(), meeting.getCreatedBy().getId(), meeting.getInvitedUser().getId());
        rabbitTemplate.convertAndSend(topicExchange, newOnlineMeetingRoutingKey, serializableMeeting);
    }

}
