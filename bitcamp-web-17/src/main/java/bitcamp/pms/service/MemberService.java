package bitcamp.pms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Service
public class MemberService {
    
    @Autowired
    MemberDao memberDao;

    public List<Member> list(int page, int size) {
        HashMap<String, Object> params = new HashMap<>();

        if (page > 0 && (size > 0 && size <= 20))  {
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }
        
        return memberDao.selectList(params);
    }

    public Member get(String id) {
        return memberDao.selectOne(id);
    }

    // @Transactional
    public int update(Member member) {
        int count = memberDao.update(member);
        /* if (count != 100)
            throw new RuntimeException("일부러 예외발생"); */
        return count;
    }

    public int delete(String id) {
        return memberDao.delete(id);
    }

    public void add(Member member) {
        memberDao.insert(member);
    }
    
    public int getTotalPage(int size) {
        int count = memberDao.countAll();
        int totalPage = count / size;
        if (count % size > 0) 
            totalPage++;
        return totalPage;
    }
    
}
