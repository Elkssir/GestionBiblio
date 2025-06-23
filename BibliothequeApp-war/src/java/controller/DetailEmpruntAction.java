package controller;

import entity.Emprunt;
import metier.GererEmprunts;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailEmpruntAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Emprunt emprunt = GererEmprunts.chercherEmprunt(id);
            request.setAttribute("emprunt", emprunt);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mapping.findForward("detailEmprunt");
    }
}
