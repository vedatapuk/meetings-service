package com.meetings.meetings.services;

import com.meetings.meetings.PerRequestIdStorage;
import com.meetings.meetings.integration.producers.MeetingProducer;
import com.meetings.meetings.mappers.MeetingMapper;
import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.models.MeetingUser;
import com.meetings.meetings.repositories.MeetingRepo;
import com.meetings.meetings.transports.MeetingListTransport;
import com.meetings.meetings.transports.MeetingTransport;
import com.meetings.meetings.type.MeetingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    private MeetingRepo meetingRepository;

    @Autowired
    private MeetingUserService meetingUserService;

    @Autowired
    private MeetingProducer meetingProducer;

    @Override
    public MeetingTransport saveMeeting(MeetingTransport meetingTransport) {
        MeetingUser createdBy = meetingUserService.getMeetingUserById(PerRequestIdStorage.getUserId());
        MeetingUser invitedUser = meetingUserService.getMeetingUserById(meetingTransport.getInvitedUser());
        Meeting meeting = MeetingMapper.meetingTransportToMeeting(createdBy, invitedUser, meetingTransport);
        Meeting savedMeeting = meetingRepository.save(meeting);
        meetingProducer.sendNewMeeting(savedMeeting);
        return MeetingMapper.meetingToMeetingTransport(savedMeeting);
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getMeetingById(String id) {
        return meetingRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Meeting not found!"));
    }

    @Override
    public List<Meeting> getMeetingsByStatus(String status){
        return meetingRepository.findByMeetingStatus(MeetingStatus.valueOf(status));
    }

    @Override
    public List<Meeting> getMeetingsByPlace(String place) {
        return meetingRepository.findByPlace(place);
    }

    @Override
    public Meeting commentToMeeting(String comment) {
        return null;
    }

    @Transactional
    @Override
    public void deleteMeeting(String id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public MeetingTransport updateMeeting(String meetingId, MeetingTransport meetingTransport) {
        MeetingUser createdBy = meetingUserService.getMeetingUserById(meetingTransport.getCreatedBy());
        MeetingUser invitedUser = meetingUserService.getMeetingUserById(meetingTransport.getInvitedUser());
        Meeting meeting = MeetingMapper.meetingTransportToMeeting(createdBy, invitedUser, meetingTransport);
        return MeetingMapper.meetingToMeetingTransport(meetingRepository.save(meeting));
    }

    @Override
    public MeetingTransport updateComment(String meetingId, MeetingTransport meetingTransport) {
        String comment = meetingTransport.getComment();
        Meeting meeting = getMeetingById(meetingTransport.getId());
        meeting.setComment(comment);
        return MeetingMapper.meetingToMeetingTransport(meetingRepository.save(meeting));
    }

    @Override
    public List<Meeting> getMeetingsByUserId(String userId) {
//        List<Meeting> meetings = new ArrayList<>();
//        MeetingUser meetingUser = meetingUserService.getMeetingUserById(userId);
//        List<Meeting> meetingsCreated = meetingUser.getMeetingsCreated();
//        List<Meeting> meetingsInvited = meetingUser.getMeetingsInvited();
//        meetings.addAll(meetingsCreated);
//        meetings.addAll(meetingsInvited);
//        return meetings;
        meetingProducer.sendNewMeeting(null);
        return null;
    }

    @Override
    public List<Meeting> getAllMeetingsBetween(Timestamp startTime, Timestamp endTime) {
        return meetingRepository.findAllMeetingsBetweenTimes(startTime, endTime);
    }

}
