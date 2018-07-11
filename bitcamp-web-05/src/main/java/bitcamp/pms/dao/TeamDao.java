package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Team;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TeamDao {

    SqlSessionFactory sqlSessionFactory;

    public TeamDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Team> selectList(Map<String, Object> params) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("team.selectList", params);
        }
    }
    
    
    public Team selectOne(String name) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("team.selectOne", name);
        }
    }
    
    public int insert(Team team) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.insert("team.insert", team);
            sqlSession.commit();
            return count;
        }
    }
    
    public int update(Team team) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.update("team.update", team);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(String name) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.delete("team.delete", name);
            sqlSession.commit();
            return count;
        }
    }
    
} // class
