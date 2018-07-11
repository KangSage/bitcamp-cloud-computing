package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.domain.Team;

public class TeamDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    String jdbcUrl;
    String username;
    String password;
    
    public TeamDao(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }
    
    public List<Team> selectList() throws Exception {
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "select name, sdt, edt, max_qty from pms2_team");
            ResultSet rs = stmt.executeQuery();) {
            List<Team> list = new ArrayList<>();
            while (rs.next()) {
                Team team = new Team();
                team.setName(rs.getString("name"));
                team.setMaxQuantity(rs.getInt("max_qty"));
                team.setStartDate(rs.getDate("sdt"));
                team.setEndDate(rs.getDate("edt"));
                list.add(team);
            }
            return list;
        }
    }
    
    
    public Team selectOne(String name) throws Exception {
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "select name, dscrt, sdt, edt, max_qty from pms2_team where name=?");) {
            
            stmt.setString(1, name);
            
            try (ResultSet rs = stmt.executeQuery();) {
                Team team = new Team();
                if (rs.next()) {
                    team.setName(rs.getString("name"));
                    team.setDescription(rs.getString("dscrt"));
                    team.setMaxQuantity(rs.getInt("max_qty"));
                    team.setStartDate(rs.getDate("sdt"));
                    team.setEndDate(rs.getDate("edt"));
                }
                return team;
            }
        }
    }
    
    public void insert(Team team) throws Exception {
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms2_team(name,dscrt,max_qty,sdt,edt) values(?,?,?,?,?)");) {
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getDescription());
            stmt.setInt(3, team.getMaxQuantity());
            stmt.setDate(4, team.getStartDate());
            stmt.setDate(5, team.getEndDate());
            stmt.executeUpdate();
        }
    }
    
    public int update(Team team) throws Exception {
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "update pms2_team set dscrt=?, max_qty=?, sdt=?, edt=? where name=?");) {
            
            stmt.setString(1, team.getDescription());
            stmt.setInt(2, team.getMaxQuantity());
            stmt.setDate(3, team.getStartDate());
            stmt.setDate(4, team.getEndDate());
            stmt.setString(5, team.getName());
            
            return stmt.executeUpdate();
        }
    }
    
    public int delete(String name) throws Exception {
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_team where name=?");) {
            stmt.setString(1, name);
            return stmt.executeUpdate();
        } 
    }
    
} // class
