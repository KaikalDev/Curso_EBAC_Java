package kaique.luan.dev;

import kaique.luan.dev.dao.AcessoriosDAO;
import kaique.luan.dev.dao.CarroDAO;
import kaique.luan.dev.dao.MarcaDAO;
import kaique.luan.dev.dao.interfaces.IAcessoriosDAO;
import kaique.luan.dev.dao.interfaces.ICarroDAO;
import kaique.luan.dev.dao.interfaces.IMarcaDAO;
import kaique.luan.dev.domain.Acessorio;
import kaique.luan.dev.domain.Carro;
import kaique.luan.dev.domain.Marca;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class CarroDaoTest {

    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;
    private IAcessoriosDAO acessoriosDAO;


    public CarroDaoTest() {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
        acessoriosDAO = new AcessoriosDAO();
    }

    public Acessorio criarAcessorio(String modelo, Double preco) {
        Acessorio acess = new Acessorio();
        acess.setModelo(modelo);
        acess.setPreco(preco);

        return acess;
    }

    public Marca criarMarca(String nome) {
        Marca fiat = new Marca();
        fiat.setNome(nome);

        return marcaDAO.cadastrar(fiat);
    }

    @After
    public void endTest() {
        carroDAO.excluirTudo();
        acessoriosDAO.excluirTudo();
        marcaDAO.excluirTudo();
    }

    @Test
    public void cadastrarTest() {
        Acessorio acess1 = criarAcessorio("R1", 600D);
        Acessorio acess2 = criarAcessorio("F3", 500D);
        Marca marca = criarMarca("Fiat");

        Carro carro = new Carro();
        carro.setModelo("A1");
        carro.setKiloMetragem(10000L);
        carro.setPreco(40000D);
        carro.add(acess1);
        carro.add(acess2);
        carro.setMarca(marca);

        carro = carroDAO.cadastrar(carro);
        Carro carroBD = carroDAO.buscar(carro.getModelo());

        Assert.assertNotNull(carroBD);
        Assert.assertNotNull(carroBD.getId());
        Assert.assertEquals(carro.getId(), carroBD.getId());
    }
}
