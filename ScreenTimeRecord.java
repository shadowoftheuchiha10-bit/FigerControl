package com.example.parentalcontrol.models;

public class ScreenTimeRecord {
    private String userId;
    private long startTimeMillis;
    private long endTimeMillis;

    public ScreenTimeRecord(String userId, long startTimeMillis, long endTimeMillis) {
        this.userId = userId;
        this.startTimeMillis = startTimeMillis;
        this.endTimeMillis = endTimeMillis;
    }

    public String getUserId() { return userId; }
    public long getStartTimeMillis() { return startTimeMillis; }
    public long getEndTimeMillis() { return endTimeMillis; }

    public long getDurationMillis() {
        return endTimeMillis - startTimeMillis;
    }
}