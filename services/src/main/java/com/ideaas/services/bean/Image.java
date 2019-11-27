package com.ideaas.services.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Image {

    @JsonIgnore
    private String name;
    private String url;
    @JsonIgnore
    private Boolean main;

    public Image(String url, String name, boolean main) {
        this.url = url;
        this.name = name;
        this.main = main;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
