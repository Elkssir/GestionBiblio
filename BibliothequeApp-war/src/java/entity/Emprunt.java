package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "livre_code", nullable = false)
    private Livre livre;

    @ManyToOne
    @JoinColumn(name = "adherent_numero", nullable = false)
    private Adherent adherent;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_emprunt", nullable = false)
    private Date dateEmprunt;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_retour")
    private Date dateRetour;

    @Column(nullable = false)
    private boolean retourne = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_retour_prevue", nullable = false)
    private Date dateRetourPrevue;

    public Emprunt() {
    }

    public Emprunt(Livre livre, Adherent adherent, Date dateEmprunt, Date dateRetour) {
        this.livre = livre;
        this.adherent = adherent;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public boolean isRetourne() {
        return retourne;
    }

    public void setRetourne(boolean retourne) {
        this.retourne = retourne;
    }

    public Date getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(Date dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }
    
    public String getStatut() {
    if (this.retourne) {
        return "retourne";
    }

    Date today = new Date();
    if (this.dateRetourPrevue != null) {
        if (today.after(this.dateRetourPrevue)) {
            return "retard";
        } else {
            return "actif";
        }
    }

    return "inconnu";
}


}
