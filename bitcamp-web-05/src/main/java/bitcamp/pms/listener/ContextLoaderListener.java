package bitcamp.pms.listener;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.dao.ClassroomDao;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.dao.TeamDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener 실행! ");

        try {
            String resource = "bitcamp/pms/config/mybatis-config.xml";
            InputStream inputStream =
                    Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            ServletContext sc = sce.getServletContext();

            MemberDao memberDao = new MemberDao(sqlSessionFactory);
            sc.setAttribute("memberDao", memberDao);

            BoardDao boardDao = new BoardDao(sqlSessionFactory);
            sc.setAttribute("boardDao", boardDao);

        } catch (IOException e) {
            e.printStackTrace();
        }


        /*

        ClassroomDao classroomDao = new ClassroomDao(jdbcUrl, username, password);
        sc.setAttribute("classroomDao", classroomDao);

        TeamDao teamDao = new TeamDao(jdbcUrl, username, password);
        sc.setAttribute("teamDao", teamDao);*/
    }
    
}
