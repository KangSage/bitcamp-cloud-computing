package bitcamp.pms.servlet.team;

import bitcamp.pms.dao.TeamDao;
import bitcamp.pms.domain.Team;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/team/list")
public class TeamListServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        HashMap<String, Object> params = new HashMap<>();

        if (request.getParameter("page") != null &&
                request.getParameter("size") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            int size = Integer.parseInt(request.getParameter("size"));
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }

        try {
            TeamDao teamDao = 
                    (TeamDao) getServletContext().getAttribute("teamDao");
            List<Team> list = teamDao.selectList(params);
            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("/team/list.jsp");
            rd.include(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }


} // class
