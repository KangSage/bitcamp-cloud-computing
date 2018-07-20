package bitcamp.pms.dao;

import bitcamp.pms.domain.Team;

import java.util.List;
import java.util.Map;

public interface TeamDao {
    List<Team> selectList(Map<String, Object> params);

    Team selectOne(String name);
    
    int insert(Team team);
    
    int update(Team team);
    
    int delete(String name);
    
} // class
