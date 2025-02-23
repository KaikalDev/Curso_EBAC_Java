package kaique.luan.dev;

import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.MaisDeUmRegistroException;
import kaique.luan.dev.Exception.TableException;
import kaique.luan.dev.Exception.TipoChaveNaoEncontradaException;
import kaique.luan.dev.dao.UserDAO;
import kaique.luan.dev.dao.interfaces.IUserDAO;
import kaique.luan.dev.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserDAOTest {
    private final IUserDAO userDAO;

    public UserDAOTest() {
        this.userDAO = new UserDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<User> list = userDAO.buscarTodos();
        list.forEach(cli -> {
            try {
                userDAO.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void searchUser() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        User user = criarUser();
        userDAO.cadastrar(user);

        User userResponse = userDAO.consultar(user.getId());
        Assert.assertNotNull(userResponse);
    }

    @Test
    public void searchUserByUserName() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        User user = criarUser();
        userDAO.cadastrar(user);

        User userResponse = userDAO.findByUserName(user.getUserName());
        Assert.assertNotNull(userResponse);
    }

    @Test
    public void saveUser() throws DAOException, MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException {
        User user = criarUser();
        User response = userDAO.cadastrar(user);
        Assert.assertNotNull(response);

        User userConsulted = userDAO.consultar(response.getId());
        Assert.assertNotNull(userConsulted);

        userDAO.excluir(user);

        User userConsulted1 = userDAO.consultar(response.getId());
        Assert.assertNull(userConsulted1);
    }

    @Test
    public void deleteuser() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        User user = criarUser();
        User response = userDAO.cadastrar(user);
        Assert.assertNotNull(response);


        User userConsulted = userDAO.consultar(response.getId());
        Assert.assertNotNull(userConsulted);

        userDAO.excluir(user);
        User userConsulted1 = userDAO.consultar(response.getId());
        Assert.assertNull(userConsulted1);
    }

    @Test
    public void changeUser() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        User user = criarUser();
        User response = userDAO.cadastrar(user);
        Assert.assertNotNull(response);

        User userConsulted = userDAO.consultar(response.getId());
        Assert.assertNotNull(userConsulted);

        userConsulted.setUserName("Kaique Luan");
        userDAO.alterar(userConsulted);

        User userChanged = userDAO.consultar(userConsulted.getId());
        Assert.assertNotNull(userChanged);
        Assert.assertEquals("Kaique Luan", userChanged.getUserName());

        userDAO.excluir(user);
        userConsulted = userDAO.consultar(response.getId());
        Assert.assertNull(userConsulted);
    }

    @Test
    public void takeAll() throws DAOException, TipoChaveNaoEncontradaException {
        User user = criarUser();
        User response = userDAO.cadastrar(user);
        Assert.assertNotNull(response);

        User user1 = new User();
        user1.setUserName("Rhubi");
        user1.setPassword("124532");
        user1.setEmail("rhubi@gmail.com");
        User response1 = userDAO.cadastrar(user1);
        Assert.assertNotNull(response1);

        Collection<User> list = userDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        list.forEach(cli -> {
            try {
                userDAO.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<User> list1 = userDAO.buscarTodos();
        assertNotNull(list1);
        assertEquals(0, list1.size());
    }

    private User criarUser() {
        User user = new User();
        user.setUserName("kaique");
        user.setPassword("123456");
        user.setEmail("kaique@gmail.com");
        return user;
    }
}
