package bitcamp.pms.controller;

import bitcamp.pms.dao.TeamDao;
import bitcamp.pms.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamDao teamDao;

    @RequestMapping("list")
    public String list(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="3") int size, Model model) throws Exception {

        if (page < 1) page =1;
        if (size < 1 || size > 20) size =3;

        // DB에서 가져올 데이터의 페이지 정보
        HashMap<String, Object> params = new HashMap<>();

        if (page > 0 && (size > 0 && size <= 20))  {
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }
        List<Team> list = teamDao.selectList(params);
        model.addAttribute("list", list);
        return "team/list";
    }

    @GetMapping(value="form")
    public void form() {
        /*리턴 값이 void면 현재 주소가 그대로 리턴됨*/
        /*return "team/form";*/
    }

    @PostMapping(value="add")
    public String add(Team team) throws Exception {
        System.out.println(team);
        teamDao.insert(team);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(String name) throws Exception {
        teamDao.delete(name);


        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(Team team) throws Exception {
        if (teamDao.update(team) == 0) {
            return "team/updatefail";
        } else {
            return "redirect:list";
        }
    }

    @RequestMapping("view/{name}")
    public String view(
            @PathVariable String name, Model model) throws Exception {

        Team team = teamDao.selectOne(name);
        model.addAttribute("team", team);
        return "team/view";
    }
}
