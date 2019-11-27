package com.ideaas.services.bean;


public class Image {

    private String name;
    private String url;
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
