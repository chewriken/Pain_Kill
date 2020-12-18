package accessingDataJPA.data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserDTO implements Serializable {

    private int id;

    @NotEmpty(message = "le champ prenom ne peut pas être vide")
    private String prenom;

    @NotEmpty(message = "le champ nom ne peut pas être vide")
    private String nom;

    @NotEmpty(message = "le champ mot de passe ne peut pas être vide")
    private String mdp;

    @NotEmpty(message = "le champ confirmation mot de passe ne peut pas être vide")
    private String mdpConfirm;

    @NotEmpty(message = "le champ login ne peut pas être vide")
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {return prenom;}

    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getMdp() {return mdp;}

    public void setMdp(String mdp) {this.mdp = mdp;}

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}
}
