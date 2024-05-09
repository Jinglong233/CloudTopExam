package com.jl.project.enums;


public enum MsgType {

    ANNOUNCEMENT("公告", 0),
    NOTIFICATION("通知", 1),
    EMAIL("邮件通知", 2);
    private String type;
    private int value;

    MsgType(String type, int value) {
        this.type = type;
        this.value = value;
    }


    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
