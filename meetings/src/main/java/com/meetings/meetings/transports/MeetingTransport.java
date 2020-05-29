package com.meetings.meetings.transports;

import java.sql.Timestamp;

public class MeetingTransport {

    private String id;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private String place;
    private String description;
    private boolean online;
    private String meetingStatus = "PENDING";
    private String createdBy;
    private String invitedUser;
    private String comment;

    public MeetingTransport() {

    }

    public MeetingTransport(String title, Timestamp startTime, Timestamp endTime, String place, String description,
                            boolean online, String meetingStatus, String createdBy, String invitedUser,
                            String comment) {
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

    public MeetingTransport(String id, String title, Timestamp startTime, Timestamp endTime, String place, String description,
                            boolean online, String meetingStatus, String createdBy, String invitedUser,
                            String comment) {
        this.id = id;
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

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getInvitedUser() {
        return invitedUser;
    }

    public void setInvitedUser(String invitedUser) {
        this.invitedUser = invitedUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
