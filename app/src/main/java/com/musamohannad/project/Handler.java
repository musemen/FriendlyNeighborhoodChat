package com.musamohannad.project;


public class Handler {

    protected ListOfRequests allRequests;
    private ListOfProfile allProfiles;

    public Handler() {
        allProfiles = new ListOfProfile();
        allRequests = new ListOfRequests();
    }

    public void addToAllRequest(Request request) {
        allRequests.addRequest(request);
    }

    public void addToAllProfile(Profile profile) {
        allProfiles.addProfile(profile);
    }
}
