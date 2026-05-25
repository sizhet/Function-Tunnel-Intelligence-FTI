package com.dbm.fti.drone.model;

public class NavigationResult {

    private final boolean success;
    private final String message;

    public NavigationResult(
            boolean success,
            String message) {

        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}