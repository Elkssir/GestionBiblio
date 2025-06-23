package metier;

import entity.Adherent;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GererAdherents {

    private static Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }

    // Ajouter un nouvel adhérent
    public static void ajouterAdherent(Adherent adherent) {
        Session s = getSession();
        s.beginTransaction();
        s.save(adherent);
        s.getTransaction().commit();
        s.close();
    }

    // Supprimer un adhérent par son numéro
    public static void supprimerAdherent(String numero) {
        Session s = getSession();
        s.beginTransaction();
        Adherent adherent = (Adherent) s.get(Adherent.class, numero);
        if (adherent != null) {
            s.delete(adherent);
            s.getTransaction().commit();
        }
        s.close();
    }

    // Rechercher un adhérent
    public static Adherent chercherAdherent(String numero) {
        Session s = getSession();
        Adherent adherent = (Adherent) s.get(Adherent.class, numero);
        s.close();
        return adherent;
    }

    // Lister tous les adhérents
    public static List<Adherent> listerAdherents() {
        Session s = getSession();
        List<Adherent> list = s.createQuery("from Adherent").list();
        s.close();
        return list;
    }

    // Mettre à jour un adhérent
    public static void updateAdherent(Adherent adherent) {
        Session s = getSession();
        s.beginTransaction();

        Adherent existing = (Adherent) s.get(Adherent.class, adherent.getNumero());
        if (existing != null) {
            existing.setPrenom(adherent.getPrenom());
            existing.setNom(adherent.getNom());
            existing.setEmail(adherent.getEmail());
            existing.setTelephone(adherent.getTelephone());
            existing.setDateInscription(adherent.getDateInscription());
            existing.setStatut(adherent.getStatut());

            s.update(existing);
            s.getTransaction().commit();
        }

        s.close();
    }
}
