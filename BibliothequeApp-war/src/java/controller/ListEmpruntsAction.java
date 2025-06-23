package controller;

import metier.GererEmprunts;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListEmpruntsAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("emprunts", GererEmprunts.listerEmprunts());

        return mapping.findForward("listEmprunts");
    }
}
