package com.musamohannad.project;

import java.sql.Time;

public class Request {

    private String name;
    private LatLon location;
    private Time time;
    private ListOfProfile attending;
    private Time timeMade;
    private Profile profile;
    private Activities activities;

    public Request(Profile profile, String name, LatLon location, Time time, ListOfProfile attending,
                   Time timeMade){
        this.name = name;
        this.location = location;
        this.time = time;
        this.attending = attending;
        this.timeMade = timeMade;
        this.profile = profile;
        activities = new Activities();

        this.attending.addProfile(profile);
        //profile.getGoingTo().addRequest(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(LatLon location) {
        this.location = location;
    }

    public LatLon getLocation() {
        return location;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTimeMade(Time timeMade) {
        this.timeMade = timeMade;
    }

    public Time getTimeMade() {
        return timeMade;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public Activities getActivities() {
        return activities;
    }

    public void addAttendee(Profile attendee) {
        if (!attending.getProfiles().contains(attendee)) {
            attending.getProfiles().add(attendee);
        }
    }

    public void removeAttendee(Profile attendee) {
        if (attending.getProfiles().contains(attendee)) {
            attending.getProfiles().remove(attendee);
        }
    }
}
