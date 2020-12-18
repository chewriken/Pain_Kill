package accessingDataJPA.model;
//package com.example.restservice;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sondage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public String name;
    public String place;
    public String date;
    public String description;
    public boolean vote;

    public Sondage(long id, String name, String place, String date, String description, Boolean vote){

        //super();
        this.id = id;
        this.name = name;
        this.place = place;
        this.date = date;
        this.description = description;
        this.vote = vote;
    }

    public Sondage() {
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
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
