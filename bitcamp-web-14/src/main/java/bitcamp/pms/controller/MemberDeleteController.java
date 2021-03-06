package bitcamp.pms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.MemberDao;

@Controller
public class MemberDeleteController {
    MemberDao memberDao;

    public MemberDeleteController() {}

    public MemberDeleteController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping("/member/delete")
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
            memberDao.delete(request.getParameter("id"));
            return "redirect:list";
    }
}
