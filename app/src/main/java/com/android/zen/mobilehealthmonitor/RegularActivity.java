package com.android.zen.mobilehealthmonitor;

/**
 * Created by ASUS-PC on 16.5.2017.
 */

public class RegularActivity {

    private boolean isActive;
    private String activityName;
    private int INCREASE_SECONDS;

    public RegularActivity(String name, int increaseSecond){
        isActive = false;
        activityName = name;
        INCREASE_SECONDS = increaseSecond;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getIncreaseSeconds(){
        return  INCREASE_SECONDS;
    }
}
