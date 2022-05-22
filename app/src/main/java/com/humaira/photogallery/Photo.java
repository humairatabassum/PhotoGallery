package com.humaira.photogallery;

public class Photo {


    String url = "";
    String details = "";

    public Photo(String url, String details) {
        this.url = url;
        this.details = details;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String description) {
        this.details = details;
    }
}

