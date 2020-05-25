package com.meetings.meetings.repositories;

import com.meetings.meetings.models.MeetingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingUserRepo extends JpaRepository<MeetingUser, String> {
}
