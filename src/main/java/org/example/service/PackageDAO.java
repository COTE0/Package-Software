package org.example.service;

import org.example.model.Package;
import org.example.util.SqlUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO {
    public List<Package> getAllPackageCords(){
        try (Connection conn = DatabaseManager.getConnection()) {
            List<Package> list=new ArrayList<>();
            Statement stmt = conn.createStatement();
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
    public void insertPack(Package pckg) {
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
}
