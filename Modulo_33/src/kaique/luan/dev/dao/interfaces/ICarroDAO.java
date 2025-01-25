package kaique.luan.dev.dao.interfaces;

import kaique.luan.dev.domain.Carro;

public interface ICarroDAO {
    Carro cadastrar(Carro carro);

    Carro buscar(String modelo);

    void excluirTudo();
}
