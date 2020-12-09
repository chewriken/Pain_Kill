package accessingDataJPA.model;
//package com.example.restservice;

public class Sondage {
    private long id;
    public String name;
    public String place;
    public String date;
    public String description;

    public Sondage(long id, String name, String place, String date, String description){

        //super();
        this.id = id;
        this.name = name;
        this.place = place;
        this.date = date;
        this.description = description;
    }

    public Sondage() {
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPlace() {
        return place;
    }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Session paintball [Id:" + id + ", Name:" + name + ", Description:" + description + ", Date de rendez-vous:" + date + ", Lieu:" + place + "]";
    }
}