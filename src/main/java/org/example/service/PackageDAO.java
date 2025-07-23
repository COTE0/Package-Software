package org.example.service;

import org.example.model.Client;
import org.example.model.Package;
import org.example.util.SqlUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PackageDAO {
    public static void resetTable(String table){
        Set<String> allowedTables = Set.of("packages", "cl");
        if (!allowedTables.contains(table)) {
            throw new IllegalArgumentException("Unknown table!");
        }
        String sql = "TRUNCATE TABLE "+table;
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Client> getAllClients(){
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();) {
            List<Client> list=new ArrayList<>();
            stmt.executeQuery(SqlUtil.getStringQuary("all_clients.sql"));
            ResultSet rs=stmt.getResultSet();
            while (rs.next()){
                Client cl=new Client();
                cl.setClient_id(rs.getInt("client_id"));
                cl.setFirst_name(rs.getString("first_name"));
                cl.setLast_name(rs.getString("last_name"));
                list.add(cl);
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Package> getAllPackages(){
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();) {
            List<Package> list=new ArrayList<>();
            stmt.executeQuery(SqlUtil.getStringQuary("all_packages.sql"));
            ResultSet rs=stmt.getResultSet();
            while (rs.next()){
                Package pckg=new Package();
                pckg.setP_ID(rs.getInt("P_ID"));
                pckg.setClient_id(rs.getInt("client_id"));
                pckg.setDestX(rs.getFloat("destX"));
                pckg.setDestY(rs.getFloat("destY"));
                pckg.setTime_origin(rs.getDate("time_origin").toLocalDate());
                list.add(pckg);
            }
            rs.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertPack(Package pckg) {
        String sql = "INSERT INTO packages (client_id, destX, destY, time_origin) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pckg.getClient_id());
            stmt.setFloat(2, pckg.getDestX());
            stmt.setFloat(3, pckg.getDestY());
            stmt.setDate(4, java.sql.Date.valueOf(pckg.getTime_origin()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertClient(Client cl){
        String sql = "INSERT INTO cl (first_name, last_name) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cl.getFirst_name());
            stmt.setString(2, cl.getLast_name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
