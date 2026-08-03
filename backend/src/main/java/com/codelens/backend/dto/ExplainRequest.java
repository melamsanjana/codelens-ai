package com.codelens.backend.dto;

public class ExplainRequest {

    private String error;

    public ExplainRequest() {
    }

    public ExplainRequest(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}