package com.musamohannad.project;

import java.sql.Time;
import java.util.*;

public class Profile extends Handler{

    private String name;
    private int points;
    private Activities activities;
    private LatLon location;

//    private ListOfRequests outgoingRequests;
//    private ListOfRequests incomingRequests;
    private ListOfRequests events;

    public Profile(String name, int points, Activities activities, LatLon location) {
        this.name = name;
        this.points = points;
        this.activities = activities;
        this.location = location;

//        outgoingRequests = new ListOfRequests();
//        incomingRequests = new ListOfRequests();
        events = new ListOfRequests();

    }

    // write down methods later
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public Set getActivities() {
        return activities.getAllActivities();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLocation(LatLon location) {
        this.location = location;
    }

    public LatLon getLocation() {
        return location;
    }

//    public ListOfRequests getOutgoingRequests() {
//        return outgoingRequests;
//    }
//
//    public ListOfRequests getIncomingRequests() {
//        return incomingRequests;
//    }

    public ListOfRequests getGoingTo() {
        return events;
    }

    public void makeRequest(Request request) {
        super.allRequests.addRequest(request);
    }

    public Request findRequest(Request request) {
        for (Request r :super.allRequests.getListOfRequests()) {
            if (r.equals(request)) {
                return request;
            }
        }
        return null;
    }

    public List<Request> findThisRequests() {
        List temp = new ArrayList<Request>();
        for (Request r : super.allRequests.getListOfRequests()) {
            if (r.getProfile().equals(this)) {
                temp.add(r);
            }
        }
        return temp;
    }

    public Profile makeProfile(String name){

        Activities activities = new Activities();
        Profile p = new Profile("", 0, activities, null);
        if (!name.equals("")) {
            p.setName(name);
        }
        p.setPoints(100);
        Activity a = new Activity("", 100);
        activities.addActivity(a);

        return p;
    }

    public void goingTo(Request request) {
        events.addRequest(request);
        request.addAttendee(this);
    }

    public TreeMap<Integer, Request> filterRequests(LatLon location, Time time, Activities activities, double range) {
        String stringTime = time.toString();
        TreeMap<Integer, Request> tm = new TreeMap<>();
        for (Request r : super.allRequests.getListOfRequests()) {
            if (findNearestTo(range, super.allRequests, location) && (compareTo(r.getTime(), time))) {
                tm.put(r.getActivities().containsSome(activities), r);
            }
        }
        return tm;
    }

    public boolean compareTo(Time time0, Time time1) {
        if (time0.compareTo(time1) <= 0) { // if time 0 is before than time1
            return true;
        } else if (time0.compareTo(time1) > 0) {
            return false;
        }
        return false;
    }

    // helper method time to integer
//    public int timeToInteger(Time time) {
//        Integer hour = time.getHours();
//        Integer minute = time.getMinutes();
//        Integer date = time.getDate();
//
//        return
//    }

    // find the closest
    public boolean findNearestTo(double radius, ListOfRequests requests, LatLon location) {
        boolean temp = false;
        double within = radius;
        for (Request r : requests.getListOfRequests()) {
            if (SphericalGeometry.distanceBetween(location, r.getLocation()) <= within) {
                within = SphericalGeometry.distanceBetween(location, r.getLocation());
                temp = true;
            }
        }
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return points == profile.points &&
                Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }
}
