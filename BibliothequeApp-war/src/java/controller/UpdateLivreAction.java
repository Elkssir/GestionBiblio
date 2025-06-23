package controller;

import model.LivreForm;
import metier.GererLivres;
import entity.Livre;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateLivreAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        LivreForm f = (LivreForm) form;
        System.out.println("LivreForm code = " + f.getCode());
        Livre livre = new Livre(
                f.getCode(),
                f.getTitre(),
                f.getAuteur(),
                f.getCategorie(),
                Integer.parseInt(f.getNbExemplaires())
        );

        GererLivres.updateLivre(livre);

        f.setCode("");
        f.setTitre("");
        f.setAuteur("");
        f.setCategorie("");
        f.setNbExemplaires("");

        return new ActionForward("listLivres.do", true); // true = redirect

    }
}
