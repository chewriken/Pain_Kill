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

    public Client() {}

    public Client(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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