package bitcamp.pms.service;

import bitcamp.pms.dao.ClassroomDao;
import bitcamp.pms.domain.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired ClassroomDao classroomDao;

    public List<Classroom> list(int page, int size) {
        // DB에서 가져올 데이터의 페이지 정보
        HashMap<String, Object> params = new HashMap<>();

        if (page > 0 && (size > 0 && size <= 20))  {
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }
        return classroomDao.selectList(params);
    }

    public int getTotalPage(int size) {
        int count = classroomDao.countAll();
        int totalPage = count / size;
        if (count % size  > 0)
            totalPage++;
        return totalPage;
    }

    public Classroom get(int no) {
        return classroomDao.selectOne(no);
    }


    public void add(Classroom classroom) {
        classroomDao.insert(classroom);
    }


    public int update(Classroom classroom) {
       return classroomDao.update(classroom);
    }

    public int delete(int no) {
        return classroomDao.delete(no);
    }
}
