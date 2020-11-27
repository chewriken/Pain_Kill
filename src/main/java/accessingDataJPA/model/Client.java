package accessingDataJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    private String login;
    private String mdp;


    protected Client() {}

    public Client(String prenom, String nom, String login, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', login='%s', mdp='%s']",
                id, prenom, nom, login, mdp);
    }

    public Long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getLogin() { return login;    }

    public String getMdp() { return mdp;    }
}