package com.meetings.meetings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "meeting_user")
public class MeetingUser {

    @Id
    @Column(name = "id", columnDefinition = "NVARCHAR(36)")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createdBy")
    private List<Meeting> meetingsCreated;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "invitedUser")
    private List<Meeting> meetingsInvited;

    public MeetingUser() {

    }

    public MeetingUser(String id) {
        this.id = id;
    }

    public MeetingUser(String id, String firstName, String lastName, List<Meeting> meetingsCreated, List<Meeting> meetingsInvited) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.meetingsCreated = meetingsCreated;
        this.meetingsInvited = meetingsInvited;
    }

    public MeetingUser(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MeetingUser(String id, String firstName, String lastName, String role, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Meeting> getMeetingsCreated() {
        return meetingsCreated;
    }

    public void setMeetingsCreated(List<Meeting> meetingsCreated) {
        this.meetingsCreated = meetingsCreated;
    }

    public List<Meeting> getMeetingsInvited() {
        return meetingsInvited;
    }

    public void setMeetingsInvited(List<Meeting> meetingsInvited) {
        this.meetingsInvited = meetingsInvited;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
