package bitcamp.assignment.repository;

import bitcamp.assignment.domain.Member;

import java.util.Map;

public interface MemberRepository {
    int insert(Member member);
    Member findByEmailAndPassword(Map<String, Object> params);
}
