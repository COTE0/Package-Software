package org.example.service;

import org.example.util.ConfigUtil;
import org.example.util.SqlUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/PckgDB?serverTimezone=UTC";

    private static final String PASSWORD;
    private static final String USER;

    static {
        try {
            PASSWORD = ConfigUtil.getAppConfig("PASS");
            USER = ConfigUtil.getAppConfig("USER");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createDB(){
        String url = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
        try (Connection conn = DriverManager.getConnection(url, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            final String init_sql_file="createdb.sql";
            String[] queries = SqlUtil.getStringQueries(init_sql_file);
            for(String sql:queries){
                String query=sql.trim();
                if (!query.isEmpty()){
                    stmt.execute(query);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
