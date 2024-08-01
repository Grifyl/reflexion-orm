package fr.reynaud.repository;

import fr.reynaud.dao.ProduitDao;
import fr.reynaud.model.Produit;

public class ProduitRepo {
    private ProduitDao dao = new ProduitDao();

    public void creerTable() {
        dao.creerTable();
    }

    public void insererProduit(Produit produit) {
        dao.add(produit);
    }

    public Produit chercherProduitParId(int id) {
        return dao.getById(id);
    }
}
