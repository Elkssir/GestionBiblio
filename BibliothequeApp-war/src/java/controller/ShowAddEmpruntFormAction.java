package controller;

import metier.GererAdherents;
import metier.GererLivres;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAddEmpruntFormAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("livres", GererLivres.listerLivres());
        request.setAttribute("adherents", GererAdherents.listerAdherents());

        return mapping.findForward("addEmprunt");
    }
}
