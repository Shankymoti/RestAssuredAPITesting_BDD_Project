package com.shashankkumar.enums;

public enum APIResources {
    CREATE_BOOKING("/booking"),
    AUTH("/auth"),
    UPDATE_BOOKING("/booking/%s"),
    DELETE_BOOKING("/booking/%s"),
    GET_BOOKING("/booking/%s");

    private String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
