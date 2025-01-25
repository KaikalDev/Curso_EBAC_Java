package kaique.luan.dev.dao.interfaces;

import kaique.luan.dev.domain.Acessorio;
import kaique.luan.dev.domain.Carro;
import kaique.luan.dev.domain.Marca;

public interface IMarcaDAO {
    Marca cadastrar(Marca marca);

    void excluirTudo();

    Marca buscar(String nome);
}
