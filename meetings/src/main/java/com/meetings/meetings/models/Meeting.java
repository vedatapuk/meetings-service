package com.meetings.meetings.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meetings.meetings.type.MeetingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "NVARCHAR(36)")
    private String id;

    @Column(name = "title")
    private String title;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_time")
    private Timestamp startTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "place")
    private String place;

    @Column(name = "description")
    private String description;

    @Value("false")
    @Column(name = "online")
    private Boolean online;

    @Enumerated(EnumType.STRING)
    @Column(name = "meeting_status")
    private MeetingStatus meetingStatus = MeetingStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private MeetingUser createdBy;

    @ManyToOne
    @JoinColumn(name = "invited_user")
    private MeetingUser invitedUser;

    @Column(name = "comment")
    private String comment;

    public Meeting() {

    }

    public Meeting(String title, Timestamp startTime, Timestamp endTime, String place, String description, Boolean online, MeetingStatus meetingStatus, MeetingUser createdBy, MeetingUser invitedUser, String comment) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.description = description;
        this.online = online;
        this.meetingStatus = meetingStatus;
        this.createdBy = createdBy;
        this.invitedUser = invitedUser;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public MeetingStatus getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(MeetingStatus meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public MeetingUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(MeetingUser createdBy) {
        this.createdBy = createdBy;
    }

    public MeetingUser getInvitedUser() {
        return invitedUser;
    }

    public void setInvitedUser(MeetingUser invitedUser) {
        this.invitedUser = invitedUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
