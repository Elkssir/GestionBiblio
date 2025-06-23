package controller;

import model.EmpruntForm;
import metier.GererEmprunts;
import entity.Emprunt;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class UpdateEmpruntAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EmpruntForm f = (EmpruntForm) form;

            Session session = new Configuration().configure().buildSessionFactory().openSession();
            session.beginTransaction();

            Emprunt e = (Emprunt) session.get(Emprunt.class, id);
            if (e != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Date newDateEmprunt = sdf.parse(f.getDateEmprunt());
                Date newDateRetour = (f.getDateRetour() != null && !f.getDateRetour().isEmpty())
                        ? sdf.parse(f.getDateRetour())
                        : null;

                e.setDateEmprunt(newDateEmprunt);
                e.setDateRetour(newDateRetour);
                session.update(e);
                session.getTransaction().commit();
            }

            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapping.findForward("updateEmprunt");
    }
}
