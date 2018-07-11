package bitcamp.pms.dao;

import bitcamp.pms.domain.Classroom;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

public class ClassroomDao {
    private SqlSessionFactory sqlSessionFactory;

    public ClassroomDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Classroom> selectList(Map<String, Object> params) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("classroom.selectList", params);
        }
    }

    public Classroom selectOne(int no) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("classroom.selectOne", no);
        }
    }
    
    public int insert(Classroom classroom) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.insert("classroom.insert", classroom);
            sqlSession.commit();
            return count;
        }
    }
    
    public int update(Classroom classroom) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            int count = sqlSession.update("classroom.update", classroom);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.delete("classroom.delete", no);
            sqlSession.commit();
            return count;
        }
    }
    
} // class
