package kaique.luan.dev.servlets;

import kaique.luan.dev.Enuns.WorkLevel;
import kaique.luan.dev.Enuns.WorkStatus;
import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.MaisDeUmRegistroException;
import kaique.luan.dev.Exception.TableException;
import kaique.luan.dev.Exception.TipoChaveNaoEncontradaException;
import kaique.luan.dev.dao.UserDAO;
import kaique.luan.dev.dao.WorkDAO;
import kaique.luan.dev.domain.User;
import kaique.luan.dev.domain.Work;
import kaique.luan.dev.services.UserService;
import kaique.luan.dev.services.WorkService;
import kaique.luan.dev.services.interfaces.IUserService;
import kaique.luan.dev.services.interfaces.IWorkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private IWorkService workService;
    private IUserService userService;

    @Override
    public void init() throws ServletException {
        WorkDAO workDAO = new WorkDAO();
        UserDAO userDAO = new UserDAO();
        userService = new UserService(userDAO);
        workService = new WorkService(workDAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.parseLong(req.getParameter("userid"));
        Work work = new Work();
        work.setStatus(WorkStatus.PENDENTE);

        try {
            User user = userService.consultar(userId);
            work.setUser(user);
        } catch (MaisDeUmRegistroException | TableException | DAOException e) {
            throw new RuntimeException(e);
        }

        String title = req.getParameter("title");
        work.setTitle(title);

        String description = req.getParameter("description");
        work.setDescription(description);

        String options = req.getParameter("options");
        if (options == null || options.trim().isEmpty() || WorkLevel.getByName(options) == null) {
            req.setAttribute("errorMessageOptions", "Is required");
            resp.sendRedirect("AddServlet?userid=" + userId + "&error=true");
            return;
        }
        work.setLevel(WorkLevel.getByName(options));

        try {
            workService.cadastrar(work);
        } catch (TipoChaveNaoEncontradaException | DAOException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("PageServlet?userid=" + userId + "&title=&filter=");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<String> levels = Arrays.asList(
                Arrays.stream(WorkLevel.values())
                        .map(Enum::name)
                        .toArray(String[]::new)
        );

        String errorMessage = request.getParameter("error");
        if ("true".equals(errorMessage)) {
            request.setAttribute("errorMessageOptions", "Is required");
        }

        request.setAttribute("levels", levels);
        request.getRequestDispatcher("Add.jsp").forward(request, response);
    }
}
