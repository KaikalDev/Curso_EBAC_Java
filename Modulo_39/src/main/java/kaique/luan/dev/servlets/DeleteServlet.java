package kaique.luan.dev.servlets;

import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.MaisDeUmRegistroException;
import kaique.luan.dev.Exception.TableException;
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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private IWorkService workService;

    @Override
    public void init() throws ServletException {
        WorkDAO workDAO = new WorkDAO();
        workService = new WorkService(workDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userid");
        Long taskId = Long.parseLong(req.getParameter("taskid"));

        try {
            Work work = workService.consultar(taskId);
            workService.excluir(work);

        } catch (MaisDeUmRegistroException | TableException | DAOException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("PageServlet?userid=" + userId + "&title=&filter=");
    }
}
