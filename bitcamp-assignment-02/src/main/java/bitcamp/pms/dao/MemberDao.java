package bitcamp.pms.dao;

import bitcamp.pms.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface MemberDao {

    List<Member> selectList(Map<String, Object> params);
    
    Member selectOne(String id);

    int countAll();

    int insert(Member member);

    int update(Member member);

    int delete(String id);

    int countByEmailAndPassword(HashMap<String,Object> params);
}
