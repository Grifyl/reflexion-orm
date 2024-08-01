package fr.reynaud.dao;

import fr.reynaud.model.Utilisateur;

import java.sql.*;

public class UtilisateurDao extends genericDao<Utilisateur> {
    /*private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASS = "";*/

    @Override
    protected Class<Utilisateur> getClazz() {
        return Utilisateur.class;
    }

    // TODO : implémenter cette methode dans genericDAO en utilisant la refelxoin
    public void creerTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Utilisateur " +
                    "(id INTEGER not NULL, " +
                    " nom VARCHAR(255), " +
                    " prenom VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO : implémenter cette methode dans genericDAO en utilisant la refelxoin
    public void add(Utilisateur utilisateur) {
        String sql = "INSERT INTO Utilisateur (id, nom, prenom) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, utilisateur.getId());
            pstmt.setString(2, utilisateur.getNom());
            pstmt.setString(3, utilisateur.getPrenom());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Violation containte id");
        }
    }

    /*public Utilisateur getById(int id) {
        String sql = "SELECT * FROM Utilisateur WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
