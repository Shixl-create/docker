package com.heima.ai.constant;

public enum EnumType {

    CHAT("chat");

    private final String value;
    private EnumType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }



}
