package com.musamohannad.project;

import java.util.Objects;

public class Activity {

    private String name;
    private int possiblePointsEarned;

    public Activity(String name, int possiblePointsEarned) {
        this.name = name;
        this.possiblePointsEarned = possiblePointsEarned;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPossiblePointsEarned(int possiblePointsEarned) {
        this.possiblePointsEarned = possiblePointsEarned;
    }

    public int getPossiblePointsEarned() {
        return possiblePointsEarned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return Objects.equals(name, activity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
