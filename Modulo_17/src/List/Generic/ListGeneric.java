package List.Generic;

import Models.Carro;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ListGeneric<T extends Carro> implements IListGeneric<T> {
    protected Map<Class,Map<String,T>> listGeneric;

    public abstract Class<T> getTypeClass();

    public abstract void atualizar(T entity,T entitycadastrado);

    public ListGeneric() {
        this.listGeneric = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(T entity) {
        Map<String,T> mapInterna = this.listGeneric.get(getTypeClass());
        if(mapInterna.containsKey(entity.getPlaca())) {
            return false;
        }
        mapInterna.put(entity.getPlaca(), entity);
        return true;
    }

    @Override
    public void excluir(String placa) {
        Map<String,T> mapInterna = this.listGeneric.get(getTypeClass());
        T carroCadastrado = mapInterna.get(placa);

        if (carroCadastrado != null) {
            mapInterna.remove(placa, carroCadastrado);
        }
    }

    @Override
    public void alterar(T entity) {
        Map<String,T> mapInterna = this.listGeneric.get(getTypeClass());
        T carroCadastrado = mapInterna.get(entity.getPlaca());
        if (carroCadastrado != null) {
            atualizar(entity, carroCadastrado);
        }
    }

    @Override
    public T consultar(String placa) {
        Map<String,T> mapInterna = this.listGeneric.get(getTypeClass());
        return mapInterna.get(placa);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<String,T> mapInterna = this.listGeneric.get(getTypeClass());
        return mapInterna.values();
    }
}
