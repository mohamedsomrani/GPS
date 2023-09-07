package com.exercice.GPS.Dto;

import com.exercice.GPS.Entity.GPSPosition;

public class CheckProximityRequest {
    private GPSPosition position1;
    private GPSPosition position2;

    public GPSPosition getPosition1() {
        return position1;
    }

    public void setPosition1(GPSPosition position1) {
        this.position1 = position1;
    }

    public GPSPosition getPosition2() {
        return position2;
    }

    public void setPosition2(GPSPosition position2) {
        this.position2 = position2;
    }
}
