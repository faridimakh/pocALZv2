package com.vishaluplanch.stream.kafka.model;

public enum WikiChangeType {
    NEW("new"),EDIT("edit"),CATEGORIZE("categorize"),LOG("log");
    private String value;

    private WikiChangeType(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
