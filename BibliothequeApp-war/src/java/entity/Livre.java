package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livre")
public class Livre implements Serializable {

    @Id
    @Column(length = 10)
    private String code;

    @Column(nullable = false, length = 100)
    private String titre;

    @Column(nullable = false, length = 100)
    private String auteur;

    @Column(nullable = false, length = 50)
    private String categorie;

    @Column(name = "nb_exemplaires", nullable = false)
    private int nbExemplaires;

    public Livre() {}

    public Livre(String code, String titre, String auteur, String categorie, int nbExemplaires) {
        this.code = code;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.nbExemplaires = nbExemplaires;
    }

    // Getters & Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public int getNbExemplaires() { return nbExemplaires; }
    public void setNbExemplaires(int nbExemplaires) { this.nbExemplaires = nbExemplaires; }
}
