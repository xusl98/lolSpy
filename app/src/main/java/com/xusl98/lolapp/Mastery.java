package com.xusl98.lolapp;

public class Mastery {

    private int champId;
    private long mastPoints;

    public Mastery(int champId, long mastPoints) {
        this.champId = champId;
        this.mastPoints = mastPoints;
    }

    public int getChampId() {
        return champId;
    }

    public long getMastPoints() {
        return mastPoints;
    }
}
