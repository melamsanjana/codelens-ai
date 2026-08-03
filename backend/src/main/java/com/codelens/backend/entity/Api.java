package com.codelens.backend.entity;

public class Api {

    private Long id;
    private String name;
    private String description;
    private String endpoint;

    public Api() {
    }

    public Api(Long id, String name, String description, String endpoint) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.endpoint = endpoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}