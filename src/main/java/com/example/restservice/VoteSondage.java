package com.example.restservice;

public class VoteSondage {

    private final long id;
    private final String session;

    public VoteSondage(long id, String session) {
        this.id = id;
        this.session = session;
    }

    public long getId() {
        return id;
    }

    public String getSession() {
        return session;
    }

}
