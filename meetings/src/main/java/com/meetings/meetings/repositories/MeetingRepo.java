package com.meetings.meetings.repositories;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.type.MeetingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, Integer> {
    void deleteById(String id);

    Meeting findById(String id);

    List<Meeting> findByMeetingStatus(MeetingStatus status);

    List<Meeting> findByPlace(String place);
}
