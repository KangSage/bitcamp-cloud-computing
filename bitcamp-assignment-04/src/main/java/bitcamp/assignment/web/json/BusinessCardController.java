package bitcamp.assignment.web.json;

import bitcamp.assignment.domain.BusinessCard;
import bitcamp.assignment.domain.Member;
import bitcamp.assignment.service.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/businesscard")
public class BusinessCardController {

    BusinessCardService bizcardService;

    @Autowired
    public BusinessCardController(BusinessCardService bizcardService) {
         this.bizcardService = bizcardService;
    }

    @GetMapping("list")
    public Object list(HttpSession session) {
        Member loginUser = (Member) session.getAttribute("loginUser");

       List<BusinessCard> list =
               bizcardService.list(loginUser.getNo());

        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("list", list);
        return  result;
    }

    @GetMapping("{no}")
    public Object get(@PathVariable int no, HttpSession session) {

        Member loginUser = (Member)session.getAttribute("loginUser");

        BusinessCard bizcard = bizcardService.get(no, loginUser.getNo());

        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("data", bizcard);
        return result;
    }


}
