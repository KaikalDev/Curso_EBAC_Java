package List.Generic;

import Models.Carro;

import java.util.Collection;

public interface IListGeneric<T extends Carro> {

    public Boolean cadastrar(T entity);

    public void excluir(String placa);

    public void alterar(T entity);

    public T consultar(String placa);

    public Collection<T> buscarTodos();
}
