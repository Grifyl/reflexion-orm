package fr.reynaud;

import fr.reynaud.model.Produit;
import fr.reynaud.model.Utilisateur;
import fr.reynaud.service.ProduitService;
import fr.reynaud.service.UtilisateurService;

public class Main {
    public static void main(String[] args) {
        UtilisateurService utilisateurService = new UtilisateurService();
        utilisateurService.initialiserBD();

        Utilisateur utilisateur = utilisateurService.chercherUtilisateurParId(2);
        if (utilisateur != null) {
            System.out.println("Utilisateur trouvé : " + utilisateur);
        } else {
            System.out.println("Utilisateur non trouvé.");
        }

        System.out.println("--------------------------Produit----------------------------");

        ProduitService produitService = new ProduitService();
        produitService.initialiserBD();

        Produit produit = produitService.chercherProduitParId(2);
        if (produit != null) {
            System.out.println("Produit trouvé : " + produit);
        } else {
            System.out.println("Produit non trouvé.");
        }
    }
}