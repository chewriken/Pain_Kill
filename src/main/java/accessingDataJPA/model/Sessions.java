package accessingDataJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sessions {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int idUser;
    private long idSondage;

    public Sessions( int id_User, long id_Sondage) {
        this.idUser = id_User;
        this.idSondage = id_Sondage;
    }

    public Sessions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int id_User) {
        this.idUser = id_User;
    }

    public long getIdSondage() {
        return idSondage;
    }

    public void setIdSondage(int id_Sondage) {
        this.idSondage = id_Sondage;
    }
}
