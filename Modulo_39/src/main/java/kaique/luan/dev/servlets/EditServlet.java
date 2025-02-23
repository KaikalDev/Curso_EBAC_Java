package kaique.luan.dev.servlets;

import kaique.luan.dev.Enuns.WorkLevel;
import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.MaisDeUmRegistroException;
import kaique.luan.dev.Exception.TableException;
import kaique.luan.dev.Exception.TipoChaveNaoEncontradaException;
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
import java.util.Arrays;
import java.util.Collection;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private IWorkService workService;

    @Override
    public void init() throws ServletException {
        WorkDAO workDAO = new WorkDAO();
        workService = new WorkService(workDAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userid");
        Long taskId = Long.parseLong(req.getParameter("taskid"));
        try {
            Work work = workService.consultar(taskId);

            String title = req.getParameter("title");
            work.setTitle(title);

            String description = req.getParameter("description");
            work.setDescription(description);

            String options = req.getParameter("options");
            if (options == null || options.trim().isEmpty() || WorkLevel.getByName(options) == null) {
                req.setAttribute("errorMessageOptions", "Is required");
                resp.sendRedirect("EditServlet?userid=" + userId + "&taskid=" + work.getId() + "&error=true");
                return;
            }

            work.setLevel(WorkLevel.getByName(options));

            try {
                workService.alterar(work);
            } catch (TipoChaveNaoEncontradaException | DAOException e) {
                throw new RuntimeException(e);
            }

        } catch (MaisDeUmRegistroException | TableException | DAOException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("PageServlet?userid=" + userId + "&title=&filter=");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long taskId = Long.parseLong(request.getParameter("taskid"));
        String userId = request.getParameter("userid");
        String toggleCompleted = request.getParameter("completed");

        Work work = null;
        try {
            work = workService.consultar(taskId);
        } catch (MaisDeUmRegistroException | TableException | DAOException e) {
            throw new RuntimeException(e);
        }

        if (toggleCompleted != null) {

            try {
                workService.toggleCompleted(work);
            } catch (DAOException | TipoChaveNaoEncontradaException e) {
                throw new RuntimeException(e);
            }

            response.sendRedirect("PageServlet?userid=" + userId + "&title=&filter=");
            return;
        }

        String errorMessage = request.getParameter("error");
        if ("true".equals(errorMessage)) {
            request.setAttribute("errorMessageOptions", "Is required");
        }

        String title = work.getTitle();
        request.setAttribute("title", title);

        String description = work.getDescription();
        request.setAttribute("description", description);

        String level = work.getLevel().toString().toUpperCase();
        request.setAttribute("level", level);

        Collection<String> levels = Arrays.asList(
                Arrays.stream(WorkLevel.values())
                        .map(Enum::name)
                        .map(String::toUpperCase)
                        .toArray(String[]::new)
        );

        request.setAttribute("levels", levels);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
    }

}
