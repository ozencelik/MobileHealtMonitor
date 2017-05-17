package com.android.zen.mobilehealthmonitor;

/**
 * Created by ASUS-PC on 16.5.2017.
 */

public class NonPhysicalActivity {

    private boolean isActive;
    private String activityName;
    private int DECREASE_SECONDS;

    public NonPhysicalActivity(String name, int decreaseSecond){
        isActive = false;
        activityName = name;
        DECREASE_SECONDS = decreaseSecond;
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

    public int getDecreaseSeconds(){
        return  DECREASE_SECONDS;
    }
}
