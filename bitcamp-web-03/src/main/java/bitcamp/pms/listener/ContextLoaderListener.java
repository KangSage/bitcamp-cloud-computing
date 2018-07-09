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
        
        System.out.println("ContextLoaderListner 실행! ");
        
        ServletContext sc = sce.getServletContext();
        
        MemberDao memberDao = new MemberDao(
                "jdbc:mysql://13.209.19.155:3306/studydb", "study", "1111");
        sc.setAttribute("memberDao", memberDao);
        
        BoardDao boardDao = new BoardDao(
                "jdbc:mysql://13.209.19.155:3306/studydb", "study", "1111");
        sc.setAttribute("boardDao", boardDao);
        
        ClassroomDao classroomDao = new ClassroomDao(
                "jdbc:mysql://13.209.19.155:3306/studydb", "study", "1111");
        sc.setAttribute("classroomDao", classroomDao);
        
        TeamDao teamDao = new TeamDao(
                "jdbc:mysql://13.209.19.155:3306/studydb", "study", "1111");
        sc.setAttribute("teamDao", teamDao);
    }
    
}
