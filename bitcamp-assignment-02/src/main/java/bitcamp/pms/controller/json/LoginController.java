package bitcamp.pms.controller.json;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@RestController
@RequestMapping("/auth")
public class LoginController {
    
    @Autowired
    MemberService memberService;

    @RequestMapping(value="login", method=RequestMethod.POST)
    public Object login(
            String email, 
            String password,
            HttpServletResponse response,
            HttpSession session, /* 세션 객체가 없을 경우 미리 생성할 필요 있다.*/
            Model model) {

        HashMap<String,Object> result = new HashMap<>();

        if (memberService.get(email, password) == 1) {
            result.put("status", "success");
        } else {
            result.put("status", "fail");
        }
        return result;
    }

    @RequestMapping("logout")
    public Object logout(HttpSession session, SessionStatus status) {
        
        // @SessionAttributes에서 관리하는 세션 데이터를 모두 제거한다.
        status.setComplete();
        
        // HttpSession 객체를 무효화시킨다.
        session.invalidate();
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("loginUser")
    public Object loginUser(HttpSession session) {
        
        Member member = (Member)session.getAttribute("loginUser");
        
        HashMap<String,Object> result = new HashMap<>();
        
        if (member != null) {
            result.put("status", "success");
            result.put("loginUser", member);
        } else {
            result.put("status", "fail");
        }
            
        return result;
    }
}










