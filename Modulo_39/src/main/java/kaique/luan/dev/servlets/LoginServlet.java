package kaique.luan.dev.servlets;

import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.dao.UserDAO;
import kaique.luan.dev.domain.User;
import kaique.luan.dev.services.UserService;
import kaique.luan.dev.services.interfaces.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private IUserService userService;

    @Override
    public void init() throws ServletException {
        UserDAO userDAO = new UserDAO();
        userService = new UserService(userDAO);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        if (username == null || password == null ||
                username.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            if (userService.validateUser(username)) {
                request.setAttribute("errorMessageUser", "User not exist.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            } else {
                User user = userService.findByUserName(username);
                if (user == null || !user.getPassword().equals(password)) {
                    request.setAttribute("errorMessagePassword", "Passwords do not match.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                } else {
                    response.sendRedirect("PageServlet?userid=" + user.getId() + "&title=&filter=");
                }
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

    }
}
