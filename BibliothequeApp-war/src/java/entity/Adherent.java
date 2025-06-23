package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "adherent")
public class Adherent implements Serializable {

    @Id
    @Column(length = 20)
    private String numero;

    @Column(nullable = false, length = 100)
    private String prenom;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String telephone;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_inscription", nullable = false)
    private Date dateInscription;

    @Column(length = 20)
    private String statut = "actif";

    public Adherent() {}

    public Adherent(String numero, String prenom, String nom, String email, String telephone, Date dateInscription, String statut) {
        this.numero = numero;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.dateInscription = dateInscription;
        this.statut = statut;
    }

    // Getters & Setters
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Date getDateInscription() { return dateInscription; }
    public void setDateInscription(Date dateInscription) { this.dateInscription = dateInscription; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
