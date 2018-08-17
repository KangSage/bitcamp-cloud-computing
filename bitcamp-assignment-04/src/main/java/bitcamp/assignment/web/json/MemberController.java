package bitcamp.assignment.web.json;

import bitcamp.assignment.domain.Member;
import bitcamp.assignment.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("signup")
    public Object signUp(Member member) {
        System.out.println(member);
        HashMap<String, Object> result = new HashMap<>();
        try {
            memberService.add(member);
            result.put("status", "success");
        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
        return result;
    }
}
