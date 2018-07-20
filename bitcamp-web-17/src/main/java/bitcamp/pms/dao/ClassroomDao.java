package bitcamp.pms.dao;

import bitcamp.pms.domain.Classroom;

import java.util.List;
import java.util.Map;

public interface ClassroomDao {
    List<Classroom> selectList(Map<String, Object> params);

    Classroom selectOne(int no);

    int countAll();

    int insert(Classroom classroom);

    int update(Classroom classroom);

    int delete(int no);
} // class
