package com.meetings.meetings.services;

import com.meetings.meetings.PerRequestIdStorage;
import com.meetings.meetings.mappers.MeetingMapper;
import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.models.MeetingUser;
import com.meetings.meetings.repositories.MeetingRepo;
import com.meetings.meetings.transports.MeetingListTransport;
import com.meetings.meetings.transports.MeetingTransport;
import com.meetings.meetings.type.MeetingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    private MeetingRepo meetingRepository;

    @Autowired
    private MeetingUserService meetingUserService;

    @Override
    public MeetingTransport saveMeeting(Meeting meeting) {
        MeetingUser meetingCreator = meetingUserService.getMeetingUserById(PerRequestIdStorage.getUserId());
        meeting.setCreatedBy(meetingCreator);
        return MeetingMapper.meetingToMeetingTransport(meetingRepository.save(meeting));
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

    @Override
    public void deleteMeeting(String id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public MeetingTransport updateMeeting(String meetingId, MeetingTransport meetingTransport) {
        Meeting meeting = getMeetingById(meetingId);
        meeting.setTitle(meetingTransport.getTitle());
        meeting.setStartTime(meetingTransport.getStartTime());
        meeting.setEndTime(meetingTransport.getEndTime());
        meeting.setPlace(meetingTransport.getPlace());
        meeting.setDescription(meetingTransport.getDescription());
        meeting.setOnline(meetingTransport.isOnline());
        meeting.setMeetingStatus(MeetingStatus.valueOf(meetingTransport.getMeetingStatus()));
        return MeetingMapper.meetingToMeetingTransport(meetingRepository.save(meeting));
    }

    @Override
    public void addComment(String meetingId, MeetingTransport meetingTransport) {
        String comment = meetingTransport.getComment();
        Meeting meeting = getMeetingById(meetingTransport.getId());
        meeting.setComment(comment);
        meetingRepository.save(meeting);
    }

    @Override
    public MeetingListTransport getMeetingsByUserId(String userId) {
        List<Meeting> meetings = meetingRepository.findMeetingsWhereUserParticipates(userId);
        List<MeetingTransport> meetingUserTransports = meetings.stream().map(MeetingMapper::meetingToMeetingTransport).collect(Collectors.toList());
        return new MeetingListTransport(meetingUserTransports);
    }

}
