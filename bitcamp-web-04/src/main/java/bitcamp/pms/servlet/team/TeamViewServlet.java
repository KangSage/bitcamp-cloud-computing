package bitcamp.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.TeamDao;
import bitcamp.pms.domain.Team;

@SuppressWarnings("serial")
@WebServlet("/team/view")
public class TeamViewServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        response.setContentType("text/html;charset=UTF-8");

        try {
            TeamDao teamDao = 
                    (TeamDao) getServletContext().getAttribute("teamDao");
            Team team = teamDao.selectOne(name);

            request.setAttribute("team", team);
            RequestDispatcher rd = request.getRequestDispatcher("/team/view.jsp");
            rd.include(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
    
} // class
