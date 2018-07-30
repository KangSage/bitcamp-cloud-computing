package bitcamp.pms.controller.json;

import bitcamp.pms.domain.Classroom;
import bitcamp.pms.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("classroom")
public class ClassroomController {
    @Autowired ClassroomService classroomService;

    @RequestMapping("list")
    public Object list(
            @RequestParam(defaultValue="1") int page, 
            @RequestParam(defaultValue="3") int size) throws Exception {

        System.out.println(page);
        System.out.println(size);
        if (page < 1) page =1;
        if (size < 1 || size > 20) size =3;

        HashMap<String, Object> data = new HashMap<>();
        List<Classroom> list = classroomService.list(page, size);
            data.put("list", list);
            data.put("page", page);
            data.put("size", size);
            data.put("totalPage", classroomService.getTotalPage(size));
            return data;
    }

    @GetMapping(value="form")
    public void form() {
        /*리턴 값이 void면 현재 주소가 그대로 리턴됨*/
        /*return "classroom/form";*/
    }

    @RequestMapping("view/{no}")
    public String view(
            @PathVariable int no, Model model) throws Exception {

        model.addAttribute("classroom", classroomService.get(no));
        return "classroom/view";
    }

    @PostMapping(value="add")
    public String add(Classroom classroom) throws Exception {
        classroomService.add(classroom);
        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(Classroom classroom) throws Exception {
        if (classroomService.update(classroom) == 0) {
            return "classroom/updatefail";
        } else {
            return "redirect:list";
        }
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {
        classroomService.delete(no);
        return "redirect:list";
    }
}
