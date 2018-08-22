package bitcamp.assignment.repository;

import bitcamp.assignment.domain.BusinessCard;

import java.util.HashMap;
import java.util.List;

public interface BusinessCardRepository {

    List<BusinessCard> findByMemberNo(int no);

    BusinessCard findByCardNoAndMemberNo(HashMap<String, Object> params);
}
