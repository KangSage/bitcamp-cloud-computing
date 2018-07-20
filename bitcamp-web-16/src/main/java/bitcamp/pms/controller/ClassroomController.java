package bitcamp.pms.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.dao.ClassroomDao;
import bitcamp.pms.domain.Classroom;

@Controller
@RequestMapping("classroom")
public class ClassroomController {
    @Autowired ClassroomDao classroomDao;

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
            List<Classroom> list = classroomDao.selectList(params);
            model.addAttribute("list", list);
            return "classroom/list";
    }
    
    @GetMapping(value="form")
    public void form() {
        /*리턴 값이 void면 현재 주소가 그대로 리턴됨*/
        /*return "classroom/form";*/
    }
    
    @PostMapping(value="add")
    public String add(Classroom classroom) throws Exception {
        System.out.println(classroom.toString());
        classroomDao.insert(classroom);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
            classroomDao.delete(no);
            
            
            return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Classroom classroom) throws Exception {
        System.out.println(classroom);

        if (classroomDao.update(classroom) == 0) {
            return "classroom/updatefail";
        } else {
            return "redirect:list";
        }
    }
    
    @RequestMapping("view/{no}")
    public String view(
            @PathVariable int no, Model model) throws Exception {
        
        Classroom classroom = classroomDao.selectOne(no);
        model.addAttribute("classroom", classroom);
        return "classroom/view";
    }
}
