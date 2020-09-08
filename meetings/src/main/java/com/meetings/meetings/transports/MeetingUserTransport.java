package com.meetings.meetings.transports;

import com.meetings.meetings.annotations.ApiEntity;

@ApiEntity
public class MeetingUserTransport {

    private String id;
    private String firstName;
    private String lastName;
    private String role;
    private String email;

    public MeetingUserTransport(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MeetingUserTransport(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MeetingUserTransport(String id, String firstName, String lastName, String role, String email) {
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
