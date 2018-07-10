package bitcamp.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.TeamDao;
import bitcamp.pms.domain.Team;

@SuppressWarnings("serial")
@WebServlet("/team/update")
public class TeamUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try {
            Team team = new Team();
            team.setDescription(request.getParameter("description"));
            team.setMaxQuantity(Integer.parseInt(request.getParameter("maxQty")));
            team.setStartDate(Date.valueOf(request.getParameter("startDate")));
            team.setEndDate(Date.valueOf(request.getParameter("endDate")));
            team.setName(request.getParameter("name"));

            TeamDao teamDao =
                    (TeamDao) getServletContext().getAttribute("teamDao");

            if (teamDao.update(team) == 0) {
                RequestDispatcher rd =
                        request.getRequestDispatcher("/member/updatefail.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("list");
            }
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd =
                    request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

} // class
