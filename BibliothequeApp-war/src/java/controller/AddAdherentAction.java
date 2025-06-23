package controller;

import entity.Adherent;
import metier.GererAdherents;
import model.AdherentForm;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAdherentAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        AdherentForm f = (AdherentForm) form;

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(f.getDateInscription());

            Adherent adherent = new Adherent(
                f.getNumero(), f.getPrenom(), f.getNom(), f.getEmail(),
                f.getTelephone(), date, f.getStatut()
            );

            GererAdherents.ajouterAdherent(adherent);

            // reset form
            f.setNumero(""); f.setPrenom(""); f.setNom(""); f.setEmail("");
            f.setTelephone(""); f.setDateInscription(""); f.setStatut("");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapping.findForward("success");
    }
}
