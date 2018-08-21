package com.example.android.quakereport;

import java.net.MalformedURLException;
import java.net.URL;

public class EarthQuake {

    double magnitude;
    String location;
    String date;
    String time;
    String locationOffset;
    URL url;

    public EarthQuake(double magnitude,String locationOffset, String location,String date, String time, String url) throws MalformedURLException {
        this.magnitude = magnitude;
        this.locationOffset = locationOffset;
        this.location = location;
        this.date = date;
        this.time = time;
        this.url = new URL(url);
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
