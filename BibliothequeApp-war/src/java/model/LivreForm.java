package model;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;

public class LivreForm extends ActionForm {
    private String code;
    private String titre;
    private String auteur;
    private String categorie;
    private String nbExemplaires;

    // Getters & Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public String getNbExemplaires() { return nbExemplaires; }
    public void setNbExemplaires(String nbExemplaires) { this.nbExemplaires = nbExemplaires; }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (code == null || code.trim().isEmpty()) {
            errors.add("code", new ActionMessage("error.livre.code.required"));
        }

        if (titre == null || titre.trim().isEmpty()) {
            errors.add("titre", new ActionMessage("error.livre.titre.required"));
        }

        if (auteur == null || auteur.trim().isEmpty()) {
            errors.add("auteur", new ActionMessage("error.livre.auteur.required"));
        }

        if (categorie == null || categorie.trim().isEmpty()) {
            errors.add("categorie", new ActionMessage("error.livre.categorie.required"));
        }

        try {
            int nb = Integer.parseInt(nbExemplaires);
            if (nb < 0) {
                errors.add("nbExemplaires", new ActionMessage("error.livre.exemplaires.negative"));
            }
        } catch (NumberFormatException e) {
            errors.add("nbExemplaires", new ActionMessage("error.livre.exemplaires.invalid"));
        }

        return errors;
    }
}
