package bitcamp.assignment.service;

import bitcamp.assignment.domain.BusinessCard;

import java.util.List;

public interface BusinessCardService {

    List<BusinessCard> list(int no);

    BusinessCard get(int cardNo, int memberNo);

    /*int add(BusinessCard bizcard);

    int update(BusinessCard bizcard);

    int delete(int no, int no2);*/

}
