package service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class DataBaseSql {





    public void AddAnimalToDB(String str) {
        try {
            //String sqlCommandInsert = "INSERT INTO animals (name, type, birthdate, commands)" +
            //        " VALUE ('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce')";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {
                System.out.println("Connection to Store DB succesfull!");
                Statement statement = conn.createStatement();
                statement.executeUpdate(str);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
    public void getFullData() throws ClassNotFoundException {
        try {
            String sqlCommandSelect = "SELECT * FROM animals";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {

                //System.out.println("Connection to Store DB succesfull!");
                Statement statement = conn.createStatement();
                //statement.executeUpdate(sqlCommandInsert);
                ResultSet resultSet = statement.executeQuery(sqlCommandSelect);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    Date birthdate = resultSet.getDate(4);
                    String commands = resultSet.getString(5);

                    System.out.printf("%-4d%-12s%-8s%-12s%-15s\n", id, name, type, birthdate, commands);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}

