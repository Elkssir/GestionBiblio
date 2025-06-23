package controller;

import entity.Adherent;
import metier.GererAdherents;
import model.AdherentForm;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateAdherentAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        AdherentForm f = (AdherentForm) form;

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(f.getDateInscription());

            Adherent a = new Adherent(
                f.getNumero(), f.getPrenom(), f.getNom(),
                f.getEmail(), f.getTelephone(), date, f.getStatut()
            );

            GererAdherents.updateAdherent(a);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ActionForward("listAdherents.do", true);
    }
}
