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

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@Controller
@RequestMapping("board")
public class BoardController {
    @Autowired BoardDao boardDao;
    
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
            List<Board> list = boardDao.selectList(params);
            model.addAttribute("list", list);
            return "board/list";
    }
    
    @RequestMapping("view/{no}")
    public String view(
            @PathVariable int no, Model model) throws Exception {
        
        Board board = boardDao.selectOne(no);
        model.addAttribute("board", board);
        return "board/view";
    }
    
    
    @GetMapping(value="form")
    public void form() {
        /*리턴 값이 void면 현재 주소가 그대로 리턴됨*/
        /*return "board/form";*/
    }
    
    @PostMapping(value="add")
    public String add(Board board) throws Exception {
        
        boardDao.insert(board);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception {
        if (boardDao.update(board) == 0) {
            return "board/updatefail";
        } else {
            return "redirect:list";
        }
    }
    
    @RequestMapping("delete")
    public String delete(int  no) throws Exception {
            boardDao.delete(no);
            
            return "redirect:list";
    }
    

    

    
    
}
