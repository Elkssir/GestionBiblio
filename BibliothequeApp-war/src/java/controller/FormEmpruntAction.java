package controller;

import entity.Adherent;
import entity.Livre;
import metier.GererAdherents;
import metier.GererLivres;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FormEmpruntAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        List<Livre> livres = GererLivres.listerLivres();
        List<Adherent> adherents = GererAdherents.listerAdherents();

        request.setAttribute("livres", livres);
        request.setAttribute("adherents", adherents);

        return mapping.findForward("form");
    }
}
