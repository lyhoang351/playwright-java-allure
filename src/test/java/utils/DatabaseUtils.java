package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DatabaseUtils {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/horizon";
    private static String user = "root";
    private static String password = "root125p";

    static {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static Connection getConnection(String dbConfigFile) throws SQLException {
        try (FileInputStream f = new FileInputStream(dbConfigFile)) {
            // load the properties file
            Properties pros = new Properties();
            pros.load(f);
            // assign db parameters
            url = pros.getProperty("url");
            user = pros.getProperty("user");
            password = pros.getProperty("password");
            // create a connection to the database
            return getConnection();
        } catch (IOException e) {
            return null;
        }
    }

    public static ResultSet executeQuery(String queryString) throws SQLException {
        Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return stm.executeQuery(queryString);
    }

    public static List<String> getRowValue(String queryString) throws SQLException {
        List<String> rowValues = new ArrayList<>();
        try (ResultSet rs = executeQuery(queryString)) {
            int columnTotal = rs.getMetaData().getColumnCount();
            if (rs.next()) {
                for (int i = 1; i <= columnTotal; i++) {
                    rowValues.add(rs.getString(i));
                }
            }
        }
        return rowValues;
    }


}
