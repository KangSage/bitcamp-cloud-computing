package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import bitcamp.pms.domain.Member;

@Repository
public interface MemberDao {

    List<Member> selectList(Map<String,Object> params);
    
    Member selectOne(String id);

    int countAll();

    int insert(Member member);

    int update(Member member);

    int delete(String id);

}
