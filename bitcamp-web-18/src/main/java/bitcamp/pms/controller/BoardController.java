package bitcamp.pms.controller;

import java.util.HashMap;
import java.util.List;

import bitcamp.pms.service.BoardService;
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

    @Autowired BoardService boardService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(defaultValue="1") int page, 
            @RequestParam(defaultValue="3") int size, Model model) throws Exception {

        if (page < 1) page =1;
        if (size < 1 || size > 20) size =3;

        List<Board> list = boardService.list(page, size);

        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", boardService.getTotalPage(size));
            return "board/list";
    }
    
    @RequestMapping("view/{no}")
    public String view(
            @PathVariable int no, Model model) throws Exception {
        
        Board board = boardService.get(no);
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
         boardService.add(board);
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(Board board) throws Exception {
        if (boardService.update(board) == 0) {
            return "board/updatefail";
        } else {
            return "redirect:list";
        }
    }
    
    @RequestMapping("delete")
    public String delete(int no) throws Exception {
            boardService.delete(no);
            return "redirect:list";
    }
    

    

    
    
}
