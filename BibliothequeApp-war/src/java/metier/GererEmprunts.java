package metier;

import entity.Adherent;
import entity.Emprunt;
import entity.Livre;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class GererEmprunts {

    private static Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }

    // Ajouter un emprunt
    public static void ajouterEmprunt(String livreCode, String adherentNumero, Date dateEmprunt, Date dateRetourPrevue, Date dateRetour) {
        Session s = getSession();
        s.beginTransaction();

        Livre livre = (Livre) s.get(Livre.class, livreCode);
        Adherent adherent = (Adherent) s.get(Adherent.class, adherentNumero);

        if (livre != null && adherent != null) {
            Emprunt emprunt = new Emprunt();
            emprunt.setLivre(livre);
            emprunt.setAdherent(adherent);
            emprunt.setDateEmprunt(dateEmprunt);
            emprunt.setDateRetourPrevue(dateRetourPrevue);
            emprunt.setDateRetour(dateRetour);
            emprunt.setRetourne(false);

            s.save(emprunt);
            s.getTransaction().commit();
        }

        s.close();
    }

    // Liste complète des emprunts
    public static List<Emprunt> listerEmprunts() {
        Session s = getSession();
        List<Emprunt> list = s.createQuery("from Emprunt").list();
        s.close();
        return list;
    }

    // Rechercher un emprunt par ID
    public static Emprunt chercherEmprunt(int id) {
        Session s = getSession();
        Emprunt emprunt = (Emprunt) s.get(Emprunt.class, id);
        s.close();
        return emprunt;
    }

    // Mettre à jour un emprunt (ex. date de retour)
    public static void updateEmprunt(Emprunt emprunt) {
        Session s = getSession();
        s.beginTransaction();

        Emprunt existing = (Emprunt) s.get(Emprunt.class, emprunt.getId());
        if (existing != null) {
            existing.setDateRetour(emprunt.getDateRetour());
            existing.setRetourne(emprunt.isRetourne());
            s.update(existing);
            s.getTransaction().commit();
        }

        s.close();
    }

    // Supprimer un emprunt (optionnel)
    public static void supprimerEmprunt(int id) {
        Session s = getSession();
        s.beginTransaction();

        Emprunt emprunt = (Emprunt) s.get(Emprunt.class, id);
        if (emprunt != null) {
            s.delete(emprunt);
            s.getTransaction().commit();
        }

        s.close();
    }
}
