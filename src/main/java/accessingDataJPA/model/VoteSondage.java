package accessingDataJPA.model;

import javax.persistence.Entity;

public class VoteSondage {

    private final long id;
    private final String session;
    //private final String date;
    //private final String description;

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
