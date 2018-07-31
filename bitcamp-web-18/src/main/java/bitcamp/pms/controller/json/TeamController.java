package bitcamp.pms.controller.json;

import bitcamp.pms.dao.TeamDao;
import bitcamp.pms.domain.Team;
import bitcamp.pms.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired TeamDao teamDao;
    @Autowired TeamService teamService;

    @RequestMapping("list")
    public Object list(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="3") int size) throws Exception {

        if (page < 1) page =1;
        if (size < 1 || size > 20) size =3;

        HashMap<String, Object> data = new HashMap<>();
        List<Team> list = teamService.list(page, size);

        data.put("list", list);
        data.put("page", page);
        data.put("size", size);
        data.put("totalPage", teamService.getTotalPage(size));

        return data;
    }

    @RequestMapping("view/{name}")
    public Object view(
            @PathVariable String name) throws Exception {
        String urlName = URLDecoder.decode(name, "UTF-8");
        System.out.println(urlName);
        HashMap<String, Object> data = new HashMap<>();
        Team team = teamService.get(urlName);
        data.put("team", team);
        return data;
    }

    @GetMapping(value="form")
    public void form() {
        /*리턴 값이 void면 현재 주소가 그대로 리턴됨*/
        /*return "team/form";*/
    }

    @PostMapping(value="add")
    public Object add(Team team) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        teamService.add(team);
        result.put("status", "success");
        return result;
    }

    @RequestMapping("update")
    public Object update(Team team) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (teamService.update(team) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 팀이 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;
    }

    @RequestMapping("delete")
    public Object delete(String name) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (teamService.delete(name) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 팀이 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;
    }
}
