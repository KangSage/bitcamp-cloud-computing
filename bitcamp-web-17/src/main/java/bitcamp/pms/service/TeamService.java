package bitcamp.pms.service;

import bitcamp.pms.dao.TeamDao;
import bitcamp.pms.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TeamService {

    @Autowired TeamDao teamDao;

    public List<Team> list(int page, int size) {

        HashMap<String, Object> params = new HashMap<>();

        if (page > 0 && (size > 0 && size <= 20))  {
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }
        return teamDao.selectList(params);
    }

    public int getTotalPage(int size) {
        int count = teamDao.countAll();
        int totalPage = count / size;
        if (count % size > 0)
            totalPage++;
        return totalPage;
    }

    public Team get(String name) {
        return teamDao.selectOne(name);
    }

    public void add(Team team) {
        teamDao.insert(team);
    }

    public int update(Team team) {
        return teamDao.update(team);
    }

    public int delete(String name) {
        return teamDao.delete(name);
    }

} // class
