package metier;

import entity.Livre;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GererLivres {

    private static Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }

    public static void ajouterLivre(Livre livre) {
        Session s = getSession();
        s.beginTransaction();
        s.save(livre);
        s.getTransaction().commit();
        s.close();
    }

    public static void supprimerLivre(String code) {
        Session s = getSession();
        s.beginTransaction();
        Livre livre = (Livre) s.get(Livre.class, code);
        if (livre != null) {
            s.delete(livre);
            s.getTransaction().commit();
        }
        s.close();
    }

    public static Livre chercherLivre(String code) {
        Session s = getSession();
        Livre livre = (Livre) s.get(Livre.class, code);
        s.close();
        return livre;
    }

    public static List<Livre> listerLivres() {
        Session s = getSession();
        List<Livre> livres = s.createQuery("from Livre").list();
        s.close();
        return livres;
    }

    public static void updateLivre(Livre livre) {
        Session s = getSession();
        s.beginTransaction();
        Livre existing = (Livre) s.get(Livre.class, livre.getCode());
        if (existing != null) {
            existing.setTitre(livre.getTitre());
            existing.setAuteur(livre.getAuteur());
            existing.setCategorie(livre.getCategorie());
            existing.setNbExemplaires(livre.getNbExemplaires());
            s.update(existing);
            s.getTransaction().commit();
        }

        s.close();
    }

}
