package bitcamp.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.dao.ClassroomDao;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.dao.TeamDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        String jdbcUrl = "jdbc:mysql://13.209.19.155:3306/studydb";
        String username = "study";
        String password = "1111";
        
        System.out.println("ContextLoaderListner 실행! ");
        
        ServletContext sc = sce.getServletContext();
        
        MemberDao memberDao = new MemberDao(jdbcUrl, username, password);
        sc.setAttribute("memberDao", memberDao);
        
        BoardDao boardDao = new BoardDao(jdbcUrl, username, password);
        sc.setAttribute("boardDao", boardDao);
        
        ClassroomDao classroomDao = new ClassroomDao(jdbcUrl, username, password);
        sc.setAttribute("classroomDao", classroomDao);
        
        TeamDao teamDao = new TeamDao(jdbcUrl, username, password);
        sc.setAttribute("teamDao", teamDao);
    }
    
}
