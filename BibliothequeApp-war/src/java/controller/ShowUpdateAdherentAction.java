package controller;

import entity.Adherent;
import metier.GererAdherents;
import model.AdherentForm;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

public class ShowUpdateAdherentAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        String numero = request.getParameter("numero");
        System.out.println("editAdherent appelé pour numéro: " + numero);
        if (numero != null && !numero.trim().isEmpty()) {
            Adherent adherent = GererAdherents.chercherAdherent(numero);
            if (adherent != null) {
                AdherentForm f = (AdherentForm) form;
                f.setNumero(adherent.getNumero());
                f.setPrenom(adherent.getPrenom());
                f.setNom(adherent.getNom());
                f.setEmail(adherent.getEmail());
                f.setTelephone(adherent.getTelephone());
                f.setDateInscription(new SimpleDateFormat("yyyy-MM-dd").format(adherent.getDateInscription()));
                f.setStatut(adherent.getStatut());
            }
        }

        return mapping.findForward("updateAdherent");
    }
}
