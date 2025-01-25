package kaique.luan.dev;

import kaique.luan.dev.dao.AcessoriosDAO;
import kaique.luan.dev.dao.MarcaDAO;
import kaique.luan.dev.dao.interfaces.IAcessoriosDAO;
import kaique.luan.dev.dao.interfaces.IMarcaDAO;
import kaique.luan.dev.domain.Acessorio;
import kaique.luan.dev.domain.Marca;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class MarcaDaoTest {
    private IMarcaDAO marcaDAO;

    public MarcaDaoTest() {
        marcaDAO = new MarcaDAO();
    }

    @After
    public void endTest() {
        marcaDAO.excluirTudo();
    }

    @Test
    public void cadastrarTest() {
        Marca marca = new Marca();
        marca.setNome("Marca");

        marca = marcaDAO.cadastrar(marca);
        Marca marcaBD = marcaDAO.buscar(marca.getNome());

        Assert.assertNotNull(marcaBD);
        Assert.assertNotNull(marca.getId());
        Assert.assertEquals(marca.getId(), marcaBD.getId());
    }
}
