package model;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMessage;

public class AdherentForm extends ActionForm {

    private String numero;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private String dateInscription;
    private String statut;

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

    public String getDateInscription() { return dateInscription; }
    public void setDateInscription(String dateInscription) { this.dateInscription = dateInscription; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (numero == null || numero.trim().isEmpty())
            errors.add("numero", new ActionMessage("error.adherent.numero.required"));

        if (prenom == null || prenom.trim().isEmpty())
            errors.add("prenom", new ActionMessage("error.adherent.prenom.required"));

        if (nom == null || nom.trim().isEmpty())
            errors.add("nom", new ActionMessage("error.adherent.nom.required"));

        if (email == null || !email.matches("^\\S+@\\S+\\.\\S+$"))
            errors.add("email", new ActionMessage("error.adherent.email.invalid"));

        if (telephone == null || telephone.trim().isEmpty())
            errors.add("telephone", new ActionMessage("error.adherent.telephone.required"));

        if (dateInscription == null || dateInscription.trim().isEmpty())
            errors.add("dateInscription", new ActionMessage("error.adherent.date.required"));

        if (statut == null || statut.trim().isEmpty())
            errors.add("statut", new ActionMessage("error.adherent.statut.required"));

        return errors;
    }
}
