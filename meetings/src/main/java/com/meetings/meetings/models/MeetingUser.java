package com.meetings.meetings.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meetinguser")
public class MeetingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private List<Meeting> meetingsCreated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invitedUser")
    private List<Meeting> meetingsInvited;

    public MeetingUser(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
