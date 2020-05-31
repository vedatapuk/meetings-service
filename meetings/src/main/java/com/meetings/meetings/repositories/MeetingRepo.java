package com.meetings.meetings.repositories;

import com.meetings.meetings.models.Meeting;
import com.meetings.meetings.type.MeetingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, String> {

    List<Meeting> findByMeetingStatus(MeetingStatus status);

    List<Meeting> findByPlace(String place);

    @Query(value = "SELECT * FROM meeting WHERE created_by = ?1 OR invited_user = ?1", nativeQuery = true)
    List<Meeting> findMeetingsWhereUserParticipates(String userId);

    @Query(value = "SELECT * FROM meeting WHERE start_time >= ?1 AND end_time <= ?2", nativeQuery = true)
    List<Meeting> findAllMeetingsBetweenTimes(Timestamp startTime, Timestamp endTime);

}
