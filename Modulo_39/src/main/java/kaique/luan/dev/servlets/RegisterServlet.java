package kaique.luan.dev.servlets;

import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.TipoChaveNaoEncontradaException;
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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private IUserService userService;

    @Override
    public void init() throws ServletException {
        UserDAO userDAO = new UserDAO();
        userService = new UserService(userDAO);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (name == null || email == null || password == null || confirmPassword == null ||
                name.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty() || confirmPassword.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Todos os campos são obrigatórios.");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessagePassword", "Passwords do not match.");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }

        try {
            if (!userService.validateUser(name)) {
                request.setAttribute("errorMessageUser", "User already registered.");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
                return;
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);

        try {
            User userRegister = userService.cadastrar(user);

            if (userRegister != null) {
                response.sendRedirect("PageServlet?userid=" + userRegister.getId() + "&title=&filter=");
            } else {
                request.setAttribute("errorMessage", "Falha ao cadastrar. Tente novamente.");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        } catch (TipoChaveNaoEncontradaException | DAOException e) {
            request.setAttribute("errorMessage", "Erro ao processar o cadastro: " + e.getMessage());
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }

    }
}
