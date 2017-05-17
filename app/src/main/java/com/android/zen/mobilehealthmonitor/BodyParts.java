package com.android.zen.mobilehealthmonitor;

/**
 * Created by ASUS-PC on 16.5.2017.
 */

public class BodyParts {

    private String partName;
    private int TOTAL_HEALTH;
    private int localHealth;

    public final int STATUS0 = 0;
    public final int STATUS1 = 1;
    public final int STATUS2 = 2;
    public final int STATUS3 = 3;
    public final int STATUS4 = 4;

    public BodyParts(String name, int totalHealth){
        partName = name;
        TOTAL_HEALTH = totalHealth;
        localHealth = TOTAL_HEALTH;
    }

    public String getPartName() {
        return partName;
    }

    public int getTotalHealth() {
        return TOTAL_HEALTH;
    }

    public int getLocalHealth() {
        return localHealth;
    }

    public void setLocalHealth(int localHealth) {
        this.localHealth = localHealth;
    }

    public int getStatus(){
        if(localHealth < ((0.2)*TOTAL_HEALTH)){
            return STATUS0;
        }
        else if(localHealth < ((0.4)*TOTAL_HEALTH)){
            return STATUS1;
        }
        else if(localHealth < ((0.6)*TOTAL_HEALTH)){
            return STATUS2;
        }
        else if(localHealth < ((0.8)*TOTAL_HEALTH)){
            return STATUS3;
        }
        else
            return STATUS4;
    }

}
