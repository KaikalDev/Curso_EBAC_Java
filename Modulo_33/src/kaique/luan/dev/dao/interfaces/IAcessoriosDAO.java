package kaique.luan.dev.dao.interfaces;

import kaique.luan.dev.domain.Acessorio;
import kaique.luan.dev.domain.Carro;

public interface IAcessoriosDAO {
    Acessorio cadastrar(Acessorio acessorio);

    void excluirTudo();

    Acessorio buscar(String modelo);
}
