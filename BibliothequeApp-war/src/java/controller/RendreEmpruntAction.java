package controller;

import model.EmpruntForm;
import metier.GererEmprunts;
import entity.Emprunt;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RendreEmpruntAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        try {
            EmpruntForm f = (EmpruntForm) form;
System.out.println("✅ RendreEmpruntAction exécutée !");

            int id = Integer.parseInt(f.getId());
            Date retour = new SimpleDateFormat("yyyy-MM-dd").parse(f.getDateRetour());

            Emprunt emprunt = GererEmprunts.chercherEmprunt(id);
            if (emprunt != null) {
                emprunt.setDateRetour(retour);
                emprunt.setRetourne(true);
                GererEmprunts.updateEmprunt(emprunt);
           
            }

        } catch (Exception e) {
            e.printStackTrace();
            return mapping.getInputForward();
        }

        return mapping.findForward("success");
    }
}
