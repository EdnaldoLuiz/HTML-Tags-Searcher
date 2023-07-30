package com.nuti.nuti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static void createTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS tag_counts (tag VARCHAR(255), count INT)";
            PreparedStatement statement = conn.prepareStatement(createTableSQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertTagCount(String tag, int count) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertSQL = "INSERT INTO tag_counts (tag, count) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(insertSQL);
            statement.setString(1, tag);
            statement.setInt(2, count);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printTagCounts() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String selectSQL = "SELECT * FROM tag_counts";
            PreparedStatement statement = conn.prepareStatement(selectSQL);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("tag\t\tquantidade");
            System.out.println("--------------------");
            while (resultSet.next()) {
                String tag = resultSet.getString("tag");
                int count = resultSet.getInt("count");
                System.out.println(tag + "\t\t" + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
