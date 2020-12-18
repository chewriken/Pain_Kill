package accessingDataJPA.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Sondage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSondage;
    @Column(unique = true)
    public String name;
    public String place;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public String date;
    public String description;
    public Boolean status;

    public Sondage( String name, String place, String date, String description, Boolean vote){

        this.name = name;
        this.place = place;
        this.date = date;
        this.description = description;
        this.status = vote;
    }

    public Sondage() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setIdSondage(long id) {
        this.idSondage = id;
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

    public long getIdSondage() {
        return idSondage;
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
        return "Session paintball [Id:" + idSondage + ", Name:" + name + ", Description:" + description + ", Date de rendez-vous:" + date + ", Lieu:" + place + "]";
    }
}
