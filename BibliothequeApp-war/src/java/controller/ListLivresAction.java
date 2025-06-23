package controller;

import metier.GererLivres;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListLivresAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("livres", GererLivres.listerLivres());
        return mapping.findForward("listLivres");
    }
}
