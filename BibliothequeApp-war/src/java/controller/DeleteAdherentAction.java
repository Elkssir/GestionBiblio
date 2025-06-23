package controller;

import model.AdherentForm;
import metier.GererAdherents;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAdherentAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        String numero = request.getParameter("numero");  
        if (numero != null && !numero.isEmpty()) {
            GererAdherents.supprimerAdherent(numero);
        }

        return new ActionForward("listAdherents.do", true);
    }
}
