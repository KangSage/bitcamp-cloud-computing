package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Board;

public interface BoardDao {
    
    public List<Board> selectList(Map<String,Object> params);
    
    public Board selectOne(int no);
    
    public void insert(Board board);
    
    public int update(Board board);
    
    public int delete(int no);
    
    
    
}
