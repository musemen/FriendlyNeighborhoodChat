package com.musamohannad.project;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListOfProfile {

    private List<Profile> profiles;

    public ListOfProfile() {
        profiles = new ArrayList<Profile>();
    }

    public List findAllWithName(String name) {
        List temp = new ArrayList();
        for (Profile p : profiles) {
            if (p.getName().equals(name)) {
                temp.add(p);
            }
        }
        return temp;
    }

    public List<Profile> findAllWithActivity(Activity activity) {
        List<Profile> temp = new ArrayList<>();
        for (Profile p : profiles) {
            if (p.getActivities().contains(activity)) {
                temp.add(p);
            }
        }
        return temp;
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public List getProfiles() {
        return profiles;
    }

    public Profile findProfileByName(String name) {
        for (Profile p : profiles) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Profile findProfileByActivity(Activity activity) {
        for (Profile p : profiles) {
            Set activities = p.getActivities();
            for (int i = 0; i < activities.size(); i++) {
                if (activities.contains(activity)) {
                    return p;
                }
            }
        }
        return null;
    }
}
