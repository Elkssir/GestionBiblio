package model;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EmpruntForm extends ActionForm {

    private String id;
    private String livreCode;
    private String adherentNumero;
    private String dateEmprunt;
    private String dateRetour;
    private String dateRetourPrevue;

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLivreCode() {
        return livreCode;
    }

    public void setLivreCode(String livreCode) {
        this.livreCode = livreCode;
    }

    public String getAdherentNumero() {
        return adherentNumero;
    }

    public void setAdherentNumero(String adherentNumero) {
        this.adherentNumero = adherentNumero;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(String dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        String path = mapping.getPath();

        // Validation pour ajout d'emprunt
        if ("/addEmprunt".equals(path)) {
            if (livreCode == null || livreCode.trim().isEmpty()) {
                errors.add("livreCode", new ActionMessage("error.emprunt.livre.required"));
            }

            if (adherentNumero == null || adherentNumero.trim().isEmpty()) {
                errors.add("adherentNumero", new ActionMessage("error.emprunt.adherent.required"));
            }

            if (dateEmprunt == null || dateEmprunt.trim().isEmpty()) {
                errors.add("dateEmprunt", new ActionMessage("error.emprunt.date.required"));
            }

            if (dateRetourPrevue == null || dateRetourPrevue.trim().isEmpty()) {
                errors.add("dateRetourPrevue", new ActionMessage("error.emprunt.retourPrevu.required"));
            }
        }

        // Validation pour retour d'emprunt
        if ("/rendreEmprunt".equals(path)) {
            if (dateRetour == null || dateRetour.trim().isEmpty()) {
                errors.add("dateRetour", new ActionMessage("error.emprunt.dateRetour.required"));
            }
        }

        return errors;
    }
}
