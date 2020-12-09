package accessingDataJPA.model;

import accessingDataJPA.data.VoteSondageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class VoteSondage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    private String session;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String date;
    private String description;

    public VoteSondage(String session, String date, String description) {
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
