package com.musamohannad.project;

import java.util.HashSet;
import java.util.Set;

public class Activities {

    //private List<String> listOfInterest;
    private Set<Activity> required;
    private Set<Activity> allActivities;

    public Activities() {

        //listOfInterest = new ArrayList();
        required = new HashSet<Activity>(); // add if not there
        allActivities = new HashSet<Activity>();
        allActivities.addAll(required);
    }

    public void addActivity(Activity activity) {
        //listOfInterest.add(interest);
        allActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (!required.contains(activity)) {
            allActivities.remove(activity);
        }
    }

    public boolean contains(Activity activity) {
        return allActivities.contains(activity);
    }

    public int size() {
        return allActivities.size();
    }

    public Set getRequired() {
        return required;
    }

    public Set getAllActivities() {
        return allActivities;
    }

    public int containsSome(Activities activities) {
        Integer temp = 0;
        for (Activity a : activities.allActivities) {
            if (allActivities.contains(a)) {
                temp++;
            }
        }
        return temp;
    }

}
