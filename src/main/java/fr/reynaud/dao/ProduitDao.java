package fr.reynaud.dao;

import fr.reynaud.model.Produit;

import java.sql.*;

public class ProduitDao extends genericDao<Produit>{
    /*private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASS = "";*/

    @Override
    protected Class<Produit> getClazz() {
        return Produit.class;
    }

    // TODO : implémenter cette methode dans genericDAO en utilisant la refelxoin
    public void creerTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Produit " +
                    "(id INTEGER not NULL, " +
                    " libelle VARCHAR(255), " +
                    " prix DOUBLE, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO : implémenter cette methode dans genericDAO en utilisant la refelxoin
    public void add(Produit produit) {
        String sql = "INSERT INTO Produit (id, libelle, prix) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, produit.getId());
            pstmt.setString(2, produit.getLibelle());
            pstmt.setDouble(3, produit.getPrix());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Violation containte id");
        }
    }

    /*public Produit getById(int id) {
        String sql = "SELECT * FROM Produit WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Produit(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("prix"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
