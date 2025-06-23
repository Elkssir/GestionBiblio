package controller;

import metier.GererEmprunts;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteEmpruntAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            GererEmprunts.supprimerEmprunt(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ActionForward("listEmprunts.do", true);
    }
}
