package com.example.parentalcontrol.models;

public class User {
    private String id;
    private String name;
    private String fingerprintId; // Unique identifier for fingerprint
    private boolean isParent;

    public User(String id, String name, String fingerprintId, boolean isParent) {
        this.id = id;
        this.name = name;
        this.fingerprintId = fingerprintId;
        this.isParent = isParent;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getFingerprintId() { return fingerprintId; }
    public boolean isParent() { return isParent; }
}