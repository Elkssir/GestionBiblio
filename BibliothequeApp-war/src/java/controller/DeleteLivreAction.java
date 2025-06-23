package controller;

import model.LivreForm;
import metier.GererLivres;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteLivreAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        LivreForm f = (LivreForm) form;
        GererLivres.supprimerLivre(f.getCode());
        f.setCode(""); // reset
        return new ActionForward("listLivres.do", true);

    }
}
