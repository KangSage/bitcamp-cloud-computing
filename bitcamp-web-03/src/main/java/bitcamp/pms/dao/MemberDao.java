package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bitcamp.pms.domain.Member;

public class MemberDao {
    
    // MemberDao 객체를 호출시 바로 준비할 객체를 static 블록에 넣는다.
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void insert(Member member) throws Exception {
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.19.155:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms2_member(mid,email,pwd) values(?,?,password(?))");) {
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            stmt.executeUpdate();
        }
    }

    public static ArrayList<Member> selectOne() throws Exception {
        
        try (Connection con = DriverManager.getConnection(
                        "jdbc:mysql://13.209.19.155:3306/studydb",
                        "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                        "select mid, email from pms2_member");
                ResultSet rs = stmt.executeQuery();) {

            ArrayList<Member> list = new ArrayList<>();
            
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("mid"));
                member.setEmail(rs.getString("email"));
                list.add(member);
            }
            return list;
        }
        
    }
    
    public static Member selectOne(String id) throws Exception {
        
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.19.155:3306/studydb", "study", "1111");
             PreparedStatement stmt = 
                     con.prepareStatement("select mid,email from pms2_member where mid=?");) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
                    return null;
                } else {
                    Member member = new Member();
                    member.setId(rs.getString("mid"));
                    member.setEmail(rs.getString("email"));

                    return member;
                }
            }
        }
    }
    
    public static int update(Member member) throws Exception {

        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.19.155:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms2_member set email=?, pwd=password(?) where mid=?");) {
            
            stmt.setString(1, member.getEmail());
            stmt.setString(2, member.getPassword());
            stmt.setString(3, member.getId());
            
            return stmt.executeUpdate();
        }
    }
    
    
    public static int delete(String id) throws Exception {

        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://13.209.19.155:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            
        return stmt.executeUpdate();
        }
    }
    
    
} // class
