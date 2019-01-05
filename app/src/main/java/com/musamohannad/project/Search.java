package com.musamohannad.project;

import java.util.List;

public class Search {

//    private String byName;
//    private String byInterest;
//    private String bySkill;
//     TODO: do location later

    private Activities activities = new Activities();
//    private Profile profile = new Profile("", 100, activities);
    private ListOfProfile profiles = new ListOfProfile();

    public Search() {}

//    public Profile findName(String name) {
//        if (name.equals(profile.getName())) {
//            return profile;
//        }
//        return null;
//    }

//    public Profile findActivity(Activity activity) {
//        if (profile.getActivities().contains(activity)) {
//            return profile;
//        }
//        return null;
//    }

    public void printNames(String name) {
        List temp = profiles.findAllWithName(name);
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(name);
        }
    }

    public void printNamesWithCommonActivity(Activity activity) {
        List temp = profiles.findAllWithActivity(activity);
        for (int i = 0; i < temp.size(); i++) {
            Profile p = (Profile) temp.get(i);
            System.out.println(p.getName());
        }
    }

    public ListOfProfile getProfiles() {
        return profiles;
    }
}
