package kaique.luan.dev.dao.factory;

import Enums.TipoProduto;
import kaique.luan.dev.domain.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoFactory {

    public static Produto convert(ResultSet rs) throws SQLException {
        Produto prod = new Produto();
        prod.setId(rs.getLong("ID_PRODUTO"));
        prod.setCodigo(rs.getString("CODIGO"));
        prod.setNome(rs.getString("NOME"));
        prod.setDescricao(rs.getString("DESCRICAO"));
        prod.setValor(rs.getBigDecimal("VALOR"));
        prod.setTipo(TipoProduto.getByName(rs.getString("tipo")));
        prod.setEstoque(rs.getInt("estoque"));
        return prod;
    }
}