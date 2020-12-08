package accessingDataJPA.model;

import javax.persistence.Entity;

public class VoteSondage {

    private long id;
    private String session;
    private String date;
    private String description;

    public VoteSondage(long id, String session, String Date, String description) {
        this.id = id;
        this.session = session;
        this.date = date;
        this.description = description;
    }
    public VoteSondage(){

    }


    public long getId() {
        return id;
    }

    public String getSession() {
        return session;
    }

    public void setId(long id){
        this.id = id;
    }
    public void setSession(String session){
        this.session = session;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
