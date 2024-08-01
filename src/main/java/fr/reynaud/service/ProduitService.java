package fr.reynaud.service;

import fr.reynaud.model.Produit;
import fr.reynaud.repository.ProduitRepo;

public class ProduitService {
    private ProduitRepo repo = new ProduitRepo();

    public void initialiserBD() {
        repo.creerTable();
        repo.insererProduit(new Produit(1, "Ordinateur", 999.99));
        repo.insererProduit(new Produit(2, "Téléphone", 599.99));
        repo.insererProduit(new Produit(3, "Tablette", 399.99));
    }

    public Produit chercherProduitParId(int id) {
        return repo.chercherProduitParId(id);
    }
}
