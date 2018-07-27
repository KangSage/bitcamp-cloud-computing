package bitcamp.pms.controller;

import bitcamp.pms.dao.TeamDao;
import bitcamp.pms.domain.Team;
import bitcamp.pms.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired TeamDao teamDao;
    @Autowired TeamService teamService;

    @RequestMapping("list")
    public String list(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="3") int size, Model model) throws Exception {

        if (page < 1) page =1;
        if (size < 1 || size > 20) size =3;

        List<Team> list = teamService.list(page, size);

        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", teamService.getTotalPage(size));

        return "team/list";
    }

    @RequestMapping("view/{name}")
    public String view(
            @PathVariable String name, Model model) throws Exception {

        Team team = teamService.get(name);
        model.addAttribute("team", team);
        return "team/view";
    }

    @GetMapping(value="form")
    public void form() {
        /*리턴 값이 void면 현재 주소가 그대로 리턴됨*/
        /*return "team/form";*/
    }

    @PostMapping(value="add")
    public String add(Team team) throws Exception {
        teamService.add(team);
        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(Team team) throws Exception {
        if (teamService.update(team) == 0) {
            return "team/updatefail";
        } else {
            return "redirect:list";
        }
    }

    @RequestMapping("delete")
    public String delete(String name) throws Exception {
        teamService.delete(name);
        return "redirect:list";
    }
}
