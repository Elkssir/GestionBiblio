package controller;

import model.EmpruntForm;
import metier.GererEmprunts;
import metier.GererAdherents;
import metier.GererLivres;
import entity.Emprunt;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEmpruntAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        EmpruntForm f = (EmpruntForm) form;

        // Toujours recharger les listes pour éviter l'erreur JSP si validation échoue
        request.setAttribute("livres", GererLivres.listerLivres());
        request.setAttribute("adherents", GererAdherents.listerAdherents());

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date dateEmprunt = sdf.parse(f.getDateEmprunt());
            Date dateRetourPrevue = sdf.parse(f.getDateRetourPrevue());

            Date dateRetour = null;
            if (f.getDateRetour() != null && !f.getDateRetour().trim().isEmpty()) {
                dateRetour = sdf.parse(f.getDateRetour());
            }

            GererEmprunts.ajouterEmprunt(
                f.getLivreCode(),
                f.getAdherentNumero(),
                dateEmprunt,
                dateRetourPrevue,
                dateRetour
            );

            return mapping.findForward("success");

        } catch (Exception e) {
            e.printStackTrace();
            // En cas d'erreur Java, on retourne au formulaire avec les attributs chargés
            return mapping.getInputForward();
        }
    }
}
