package accessingDataJPA.model;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idUser;
    private String prenom;
    private String nom;
    @Column(unique = true)
    private String login;
    private String mdp;
    @Transient
    private String passwordConfirm;
    private String role;


    public Client() {}

    public Client(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public Client(String prenom, String nom, String login, String mdp,String role) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.mdp = mdp;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', login='%s', mdp='%s']",
                idUser, prenom, nom, login, mdp);
    }

    public void setIdUser(int id) {
        this.idUser = id;
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

    public void setRole(String role) { this.role = role; }

    public String getRole() { return role; }

    public int getIdUser() {
        return idUser;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getLogin() { return login;    }

    public String getMdp() { return mdp;    }

    public String getPasswordConfirm() {return passwordConfirm;}

    public void setPasswordConfirm(String passwordConfirm) {this.passwordConfirm = passwordConfirm;}
}