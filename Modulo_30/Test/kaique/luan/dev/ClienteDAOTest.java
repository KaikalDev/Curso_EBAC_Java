package kaique.luan.dev;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import kaique.luan.dev.dao.ClienteDAO;
import kaique.luan.dev.dao.intefaces.IClienteDAO;
import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.exceptions.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente1;
    private Cliente cliente2;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Before
    public void TestInit() throws DAOException, TipoChaveNaoEncontradaException {
        cliente1 = new Cliente();
        cliente1.setCpf(56565656565L);
        cliente1.setNome("Kaique");
        cliente1.setLastname("Luan");
        cliente1.setCidade("São Paulo");
        cliente1.setEnd("End");
        cliente1.setEstado("SP");
        cliente1.setNumero(10);
        cliente1.setTel(1199999999L);

        cliente2 = new Cliente();
        cliente2.setCpf(56565656569L);
        cliente2.setNome("Kaique");
        cliente2.setLastname("Luan");
        cliente2.setCidade("São Paulo");
        cliente2.setEnd("End");
        cliente2.setEstado("SP");
        cliente2.setNumero(10);
        cliente2.setTel(1199999999L);
    }

    @Test
    public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
        clienteDao.cadastrar(cliente1);

        Cliente clienteConsultado = clienteDao.consultar(cliente1.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente1.getCpf());
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Boolean retorno = clienteDao.cadastrar(cliente1);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente1.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente1.getCpf());
    }


    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Boolean retorno = clienteDao.cadastrar(cliente1);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente1.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteDao.excluir(cliente1.getCpf());
        clienteConsultado = clienteDao.consultar(cliente1.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        Boolean retorno = clienteDao.cadastrar(cliente1);
        Assert.assertTrue(retorno);

        Cliente clienteConsultado = clienteDao.consultar(cliente1.getCpf());
        Assert.assertNotNull(clienteConsultado);

        clienteConsultado.setNome("Rodrigo Pires");
        clienteDao.alterar(clienteConsultado);

        Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());

        clienteDao.excluir(cliente1.getCpf());
        clienteConsultado = clienteDao.consultar(cliente1.getCpf());
        Assert.assertNull(clienteConsultado);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
        Boolean retorno = clienteDao.cadastrar(cliente1);
        Assert.assertTrue(retorno);

        Boolean retorno1 = clienteDao.cadastrar(cliente2);
        Assert.assertTrue(retorno1);

        Collection<Cliente> list = clienteDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Collection<Cliente> list1 = clienteDao.buscarTodos();
        assertTrue(list1 != null);
        assertTrue(list1.size() == 0);
    }
}