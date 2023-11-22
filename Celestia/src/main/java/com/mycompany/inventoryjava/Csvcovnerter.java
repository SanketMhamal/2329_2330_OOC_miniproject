/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryjava;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Sanket
 */
public class Csvcovnerter {
     public static void main(String[] args) {
        // JDBC URL, username, and password of  server
        String url = "jdbc:derby://localhost:1527/Celestia";
        String user = "User1";
        String password = "nopass";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Execute a SQL statement to get the data from the database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT * FROM ORDERTBL CROSS JOIN PRODUCTTBL");

            // Write the data to a CSV file
            writeResultSetToCSV(resultSet, "C:\\Users\\Vinay\\Desktop\\CSV\\output6.csv");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeResultSetToCSV(ResultSet resultSet, String csvFileName) throws IOException, SQLException {
        try (FileWriter writer = new FileWriter(csvFileName)) {
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Write header
            for (int i = 1; i <= columnCount; i++) {
                writer.append(resultSet.getMetaData().getColumnName(i));
                if (i < columnCount) {
                    writer.append(",");
                }
            }
            writer.append("\n");

            // Write data
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    writer.append(resultSet.getString(i));
                    if (i < columnCount) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
}
    
    }
}