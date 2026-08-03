package com.codelens.backend.dto;

public class FixRequest {

    private String code;

    public FixRequest() {
    }

    public FixRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}