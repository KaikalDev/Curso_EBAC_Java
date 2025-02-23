package kaique.luan.dev;

import kaique.luan.dev.Enuns.WorkLevel;
import kaique.luan.dev.Enuns.WorkStatus;
import kaique.luan.dev.Exception.DAOException;
import kaique.luan.dev.Exception.MaisDeUmRegistroException;
import kaique.luan.dev.Exception.TableException;
import kaique.luan.dev.Exception.TipoChaveNaoEncontradaException;
import kaique.luan.dev.dao.UserDAO;
import kaique.luan.dev.dao.WorkDAO;
import kaique.luan.dev.dao.interfaces.IUserDAO;
import kaique.luan.dev.dao.interfaces.IWorkDAO;
import kaique.luan.dev.domain.User;
import kaique.luan.dev.domain.Work;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WorkDAOTest {
    private final IWorkDAO workDAO;
    private final IUserDAO userDAO;

    public WorkDAOTest() {
        this.userDAO = new UserDAO();
        this.workDAO = new WorkDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Work> listWork = workDAO.buscarTodos();
        listWork.forEach(work -> {
            try {
                workDAO.excluir(work);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
        Collection<User> listUser = userDAO.buscarTodos();
        listUser.forEach(user -> {
            try {
                userDAO.excluir(user);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void searchWork() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        User user = criarUser();
        userDAO.cadastrar(user);

        Work work = criarWork();
        work.setUser(user);
        workDAO.cadastrar(work);

        Work workResponse = workDAO.consultar(work.getId());
        Assert.assertNotNull(workResponse);
    }

    @Test
    public void saveWork() throws DAOException, MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException {
        User user = criarUser();
        userDAO.cadastrar(user);

        Work work = criarWork();
        work.setUser(user);
        Work response = workDAO.cadastrar(work);
        Assert.assertNotNull(response);

        Work workConsulted = workDAO.consultar(response.getId());
        Assert.assertNotNull(workConsulted);

        workDAO.excluir(work);

        Work workConsulted1 = workDAO.consultar(response.getId());
        Assert.assertNull(workConsulted1);
    }

    @Test
    public void deleteWork() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        User user = criarUser();
        userDAO.cadastrar(user);

        Work work = criarWork();
        work.setUser(user);
        Work response = workDAO.cadastrar(work);
        Assert.assertNotNull(response);

        Work workConsulted = workDAO.consultar(response.getId());
        Assert.assertNotNull(workConsulted);

        workDAO.excluir(work);
        Work workConsulted1 = workDAO.consultar(response.getId());
        Assert.assertNull(workConsulted1);
    }

    @Test
    public void changeWork() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        User user = criarUser();
        userDAO.cadastrar(user);

        Work work = criarWork();
        work.setUser(user);
        Work response = workDAO.cadastrar(work);
        Assert.assertNotNull(response);

        Work workConsulted = workDAO.consultar(response.getId());
        Assert.assertNotNull(workConsulted);

        workConsulted.setTitle("Test 2");
        workDAO.alterar(workConsulted);

        Work workChanged = workDAO.consultar(workConsulted.getId());
        Assert.assertNotNull(workChanged);
        Assert.assertEquals("Test 2", workChanged.getTitle());

        workDAO.excluir(work);
        workConsulted = workDAO.consultar(response.getId());
        Assert.assertNull(workConsulted);
    }

    @Test
    public void takeAll() throws DAOException, TipoChaveNaoEncontradaException {
        User user = criarUser();
        userDAO.cadastrar(user);

        Work work = criarWork();
        work.setUser(user);
        Work response = workDAO.cadastrar(work);
        Assert.assertNotNull(response);

        Work user1 = new Work();
        user1.setTitle("Test 2");
        user1.setDescription("Test description");
        user1.setStatus(WorkStatus.CONCLUIDA);
        user1.setLevel(WorkLevel.URGENTE);
        user1.setUser(user);
        Work response1 = workDAO.cadastrar(user1);
        Assert.assertNotNull(response1);

        Collection<Work> list = workDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        list.forEach(cli -> {
            try {
                workDAO.excluir(cli);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection<Work> list1 = workDAO.buscarTodos();
        assertNotNull(list1);
        assertEquals(0, list1.size());
    }

    private User criarUser() {
        User user = new User();
        user.setUserName("Kaique");
        user.setPassword("123456");
        user.setEmail("kaique@gmail.com");
        return user;
    }

    private Work criarWork() {
        Work work = new Work();
        work.setTitle("Test 1");
        work.setDescription("Test description");
        work.setStatus(WorkStatus.PENDENTE);
        work.setLevel(WorkLevel.NORMAL);
        return work;
    }
}
