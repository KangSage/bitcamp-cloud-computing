package bitcamp.pms.controller.json;

import bitcamp.pms.domain.Classroom;
import bitcamp.pms.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object view(
            @PathVariable int no) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("classroom", classroomService.get(no));
        return data;
    }

    @PostMapping(value="add")
    public Object add(Classroom classroom) throws Exception {
        System.out.println(classroom);
        HashMap<String, Object> result = new HashMap<>();
        classroomService.add(classroom);
        result.put("status", "success");
        return result;
    }

    @RequestMapping("update")
    public Object update(Classroom classroom) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (classroomService.update(classroom) == 0) {
            result.put("status", "fail");
            result.put("error", "강의가 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;

    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (classroomService.delete(no) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 게시물이 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;
    }
}
