package bitcamp.pms.controller.json;

import bitcamp.pms.domain.Board;
import bitcamp.pms.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("board")
public class BoardController {

    @Autowired BoardService boardService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(defaultValue="1") int page, 
            @RequestParam(defaultValue="3") int size) throws Exception {

        if (page < 1) page =1;
        if (size < 1 || size > 20) size =3;

        List<Board> list = boardService.list(page, size);

        HashMap<String, Object> data = new HashMap<>();

        data.put("list", list);
        data.put("page", page);
        data.put("size", size);
        data.put("totalPage",
                boardService.getTotalPage(size));
        return data;
    }
    
    @RequestMapping("view/{no}")
    public Object view(
            @PathVariable int no) throws Exception {
        System.out.println(no);
        HashMap<String, Object> data = new HashMap<>();
        Board board = boardService.get(no);
        data.put("board", board);
        return data;
    }
    
    
    @GetMapping(value="form")
    public void form() {
        /*리턴 값이 void면 현재 주소가 그대로 리턴됨*/
        /*return "board/form";*/
    }
    
    @PostMapping(value="add")
    public Object add(Board board) throws Exception {
        boardService.add(board);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Board board) throws Exception {

        HashMap<String, Object> result = new HashMap<>();
        if (boardService.update(board) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 게시물이 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;
    }
    
    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (boardService.delete(no) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 게시물이 없습니다.");
        } else {
        result.put("status", "success");
    }
        return result;
    }
    
}
