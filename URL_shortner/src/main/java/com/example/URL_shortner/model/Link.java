package com.example.URL_shortner.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;

@Entity
@Table(name = "urls")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String shurl;
    private LocalDateTime date;
    public Link(){
    }

    public Link(int id, String url, String shurl, LocalDateTime date) {
        this.id = id;
        this.url = url;
        this.shurl = shurl;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShurl() {
        return shurl;
    }

    public void setShurl(String shurl) {
        this.shurl = shurl;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
