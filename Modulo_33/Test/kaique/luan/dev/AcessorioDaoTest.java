package kaique.luan.dev;

import kaique.luan.dev.dao.AcessoriosDAO;
import kaique.luan.dev.dao.interfaces.IAcessoriosDAO;
import kaique.luan.dev.domain.Acessorio;
import kaique.luan.dev.domain.Carro;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AcessorioDaoTest {

    private IAcessoriosDAO acessoriosDAO;

    public AcessorioDaoTest() {
        acessoriosDAO = new AcessoriosDAO();
    }

    @After
    public void endTest() {
        acessoriosDAO.excluirTudo();
    }

    @Test
    public void cadastrarTest() {
        Acessorio acess = new Acessorio();
        acess.setModelo("A1");
        acess.setPreco(200D);

        acess = acessoriosDAO.cadastrar(acess);
        Acessorio acessBD = acessoriosDAO.buscar(acess.getModelo());

        Assert.assertNotNull(acessBD);
        Assert.assertNotNull(acess.getId());
        Assert.assertEquals(acess.getId(), acessBD.getId());
    }
}
