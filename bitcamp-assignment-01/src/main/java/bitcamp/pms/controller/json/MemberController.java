package bitcamp.pms.controller.json;

import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;

    // cookie와 session 다루기는 실패... ㅠㅠ;
    @PostMapping(value="login")
    public Object login(
            String email,
            String password) {

        System.out.println(email.toString());
        System.out.println(password.toString());
        HashMap<String,Object> result = new HashMap<>();

        int count = memberService.get(email, password);
        if (count == 1) {
            result.put("status", "success");
        } else if (count > 1) {
            result.put("status", "fail");
        }
        return result;
    }

    @CrossOrigin
    @RequestMapping("list")
    public Object list(
            @RequestParam(defaultValue="1") int page, 
            @RequestParam(defaultValue="3") int size) throws Exception {
        
        if (page < 1) page = 1;
        if (size < 1 || size > 20) size = 3;
        
        List<Member> list = memberService.list(page, size);
        
        HashMap<String,Object> data = new HashMap<>();
        data.put("list", list);
        data.put("page", page);
        data.put("size", size);
        data.put("totalPage", 
                memberService.getTotalPage(size));

        return data;
    }
    
    @GetMapping("form")
    public void form() {
    }
    
    @PostMapping("add")
    public Object add(Member member) throws Exception {
        memberService.add(member);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("delete")
    public Object delete(String id) throws Exception {

        HashMap<String, Object> result = new HashMap<>();
        if (memberService.delete(id) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 아이디가 없습니다.");
            return  result;
        } else {
            result.put("status", "success");
            return result;
        }
    }
    
    @RequestMapping("update")
    public Object update(Member member) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (memberService.update(member) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 아이디가 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;
    }
    
    @RequestMapping("view/{id}")
    public Object view(
            @PathVariable String id) throws Exception {
        String urlId = URLDecoder.decode(id, "utf-8");
        System.out.println(urlId);
        HashMap<String, Object> data = new HashMap<>();
        Member member = memberService.get(urlId);
        data.put("member", member);
        return data;
    }

}










