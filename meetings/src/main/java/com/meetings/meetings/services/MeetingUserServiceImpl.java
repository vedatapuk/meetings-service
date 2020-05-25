package com.meetings.meetings.services;

import com.meetings.meetings.models.MeetingUser;
import com.meetings.meetings.repositories.MeetingUserRepo;
import com.meetings.meetings.transports.MeetingUserTransport;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MeetingUserServiceImpl implements MeetingUserService {

    private MeetingUserRepo meetingUserRepo;

    public MeetingUserServiceImpl(MeetingUserRepo meetingUserRepo) {
        this.meetingUserRepo = meetingUserRepo;
    }

    @Override
    public void saveMeetingUser(MeetingUserTransport meetingUserTransport) {
        MeetingUser meetingUser = new MeetingUser(meetingUserTransport.getId(), meetingUserTransport.getFirstName(), meetingUserTransport.getLastName());
        meetingUserRepo.save(meetingUser);
    }

    @Override
    public MeetingUser getMeetingUserById(String id) {
        return meetingUserRepo.findById(id).orElseThrow(() -> new NoSuchElementException("User not found!"));
    }

}
