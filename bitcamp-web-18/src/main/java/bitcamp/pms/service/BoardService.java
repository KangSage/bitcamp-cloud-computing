package bitcamp.pms.service;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDao boardDao;

    public List<Board> list(int page, int size) {
        HashMap<String, Object> params = new HashMap<>();

        if (page > 0 && (size > 0 && size <= 20))  {
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }
        return boardDao.selectList(params);
    }

    public int getTotalPage(int size) {
        int count = boardDao.countAll();
        int totalPage = count / size;
        if (count % size > 0)
            totalPage++;
        return totalPage;
    }

    public Board get(int no) {
        return boardDao.selectOne(no);
    }

    public void add(Board board) {
        boardDao.insert(board);
    }

    public int update(Board board) {
       return boardDao.update(board);
    }

    public  int delete(int no) {
        return boardDao.delete(no);
    }

} // class
