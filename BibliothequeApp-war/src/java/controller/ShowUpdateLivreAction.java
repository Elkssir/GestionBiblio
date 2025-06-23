package controller;

import entity.Livre;
import metier.GererLivres;
import model.LivreForm;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUpdateLivreAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        LivreForm f = (LivreForm) form;
        String code = request.getParameter("code");
      
        if (code != null && !code.trim().isEmpty()) {
            Livre livre = GererLivres.chercherLivre(code);
            if (livre != null) {
                
                f.setCode(livre.getCode());
                f.setTitre(livre.getTitre());
                f.setAuteur(livre.getAuteur());
                f.setCategorie(livre.getCategorie());
                f.setNbExemplaires(String.valueOf(livre.getNbExemplaires()));
            }
        }

        return mapping.findForward("updateLivre");
    }
}
