package fr.reynaud.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class genericDao<T> {
    static final String DB_URL = "jdbc:h2:~/test";
    static final String USER = "sa";
    static final String PASS = "";

    protected abstract Class<T> getClazz();


    public T getById(int id) {
        T instance = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + getClazz().getSimpleName() + " WHERE id = ?")) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                instance = getClazz().getDeclaredConstructor().newInstance();
                for (Field field : getClazz().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value = rs.getObject(field.getName());
                    String methodName = "set" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
                    Method method = getClazz().getMethod(methodName, field.getType());
                    method.invoke(instance, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
