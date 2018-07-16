package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import bitcamp.pms.domain.Member;

@Repository
public interface MemberDao {

    public List<Member> selectList(Map<String,Object> params);
    
    public Member selectOne(String id);
    
    public int insert(Member member);
    
    public int update(Member member);
    
    public int delete(String id);
    
}
