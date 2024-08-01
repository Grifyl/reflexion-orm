package fr.reynaud.service;

import fr.reynaud.model.Utilisateur;
import fr.reynaud.repository.UtilisateurRepo;

public class UtilisateurService {
    private UtilisateurRepo repo = new UtilisateurRepo();

    public void initialiserBD() {
        repo.creerTable();
        repo.insererUtilisateur(new Utilisateur(1, "Dupont", "Jean"));
        repo.insererUtilisateur(new Utilisateur(2, "Durand", "Marie"));
        repo.insererUtilisateur(new Utilisateur(3, "Lefevre", "Marc"));
    }

    public Utilisateur chercherUtilisateurParId(int id) {
        return repo.chercherUtilisateurParId(id);
    }
}