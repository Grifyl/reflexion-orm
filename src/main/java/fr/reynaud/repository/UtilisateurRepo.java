package fr.reynaud.repository;

import fr.reynaud.dao.UtilisateurDao;
import fr.reynaud.model.Utilisateur;

public class UtilisateurRepo {
    private UtilisateurDao dao = new UtilisateurDao();

    public void creerTable() {
        dao.creerTable();
    }

    public void insererUtilisateur(Utilisateur utilisateur) {
        dao.add(utilisateur);
    }

    public Utilisateur chercherUtilisateurParId(int id) {
        return dao.getById(id);
    }
}
