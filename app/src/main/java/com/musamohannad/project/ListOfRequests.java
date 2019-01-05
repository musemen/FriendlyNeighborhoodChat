package com.musamohannad.project;

import java.util.ArrayList;
import java.util.List;

public class ListOfRequests {
    private static final ListOfRequests ourInstance = new ListOfRequests();

    static ListOfRequests getInstance() {
        return ourInstance;
    }

    private List<Request> requests;

    public ListOfRequests(){
        requests = new ArrayList<>();
    }

    public List<Request> getListOfRequests() {
        return requests;
    }

    public void addRequest(Request request) {
        if (!requests.contains(request)) {
            requests.add(request);
        }
    }

    public void removeRequest(Request request) {
        if (requests.contains(request)) {
            requests.remove(request);
        }
    }
}
