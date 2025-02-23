package kaique.luan.dev.servlets;

import kaique.luan.dev.Enuns.WorkLevel;
import kaique.luan.dev.Enuns.WorkStatus;
import kaique.luan.dev.dao.WorkDAO;
import kaique.luan.dev.domain.Work;
import kaique.luan.dev.services.WorkService;
import kaique.luan.dev.services.interfaces.IWorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
    private IWorkService workService;

    @Override
    public void init() throws ServletException {
        WorkDAO workDAO = new WorkDAO();
        workService = new WorkService(workDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = Long.parseLong(request.getParameter("userid"));
        String titleParam = request.getParameter("title");
        String filterParam = request.getParameter("filter");

        Collection<Work> works = workService.findByUser(userId);
        Collection<Work> filteredWorks = new ArrayList<>(works);

        if (filterParam != null && !filterParam.isEmpty()) {
            WorkStatus status = WorkStatus.getByName(filterParam);
            if (status != null) {
                filteredWorks = workService.filter(status, filteredWorks);
            } else {
                WorkLevel level = WorkLevel.getByName(filterParam);
                if (level != null) {
                    filteredWorks = workService.filter(level, filteredWorks);
                }
            }
        }

        if (titleParam != null && !titleParam.trim().isEmpty() && filteredWorks != null) {
            String titleLower = titleParam.trim().toLowerCase();
            filteredWorks = workService.filter(titleLower, filteredWorks);
        }

        Map<String, Long> filterCounts = new HashMap<>();

        for (WorkStatus filterStatus : WorkStatus.values()) {
            Collection<Work> ListFiltred = workService.filter(filterStatus, works);
            filterCounts.put(filterStatus.toString().toUpperCase(), Long.parseLong(String.valueOf(ListFiltred.size())));
        }
        for (WorkLevel filterLevel : WorkLevel.values()) {
            Collection<Work> ListFiltred = workService.filter(filterLevel, works);
            filterCounts.put(filterLevel.toString().toUpperCase(), Long.parseLong(String.valueOf(ListFiltred.size())));
        }

        request.setAttribute("Works", filteredWorks);
        request.setAttribute("WorksSize", Long.parseLong(String.valueOf(works.size())));
        request.setAttribute("filterCounts", filterCounts);
        request.getRequestDispatcher("page.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titleParam = request.getParameter("title");
        String filterParam = request.getParameter("filter");
        String userId = request.getParameter("userid");

        response.sendRedirect("PageServlet?userid=" + userId + "&title="+ titleParam +"&filter=" + filterParam);
    }
}
