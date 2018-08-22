package bitcamp.assignment.service.impl;

import bitcamp.assignment.domain.BusinessCard;
import bitcamp.assignment.repository.BusinessCardRepository;
import bitcamp.assignment.service.BusinessCardService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BusinessCardServiceImpl
        implements BusinessCardService {

    BusinessCardRepository bizcardRepository;

    public BusinessCardServiceImpl(BusinessCardRepository bizcardRepository) {
        this.bizcardRepository = bizcardRepository;
    }

    @Override
    public List<BusinessCard> list(int no) {
        return bizcardRepository.findByMemberNo(no);
    }

    @Override
    public BusinessCard get(int cardNo, int memberNo) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("cardNo", cardNo);
        params.put("memberNo", memberNo);
        return bizcardRepository.findByCardNoAndMemberNo(params);
    }
}
