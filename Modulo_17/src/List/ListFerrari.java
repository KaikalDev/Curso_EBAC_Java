package List;

import List.Generic.ListGeneric;
import List.Interfaces.IListFerrari;
import Models.Ferrari;

import java.util.HashMap;
import java.util.Map;

public class ListFerrari extends ListGeneric<Ferrari> implements IListFerrari {
    public ListFerrari() {
        super();
        Map<String, Ferrari> mapaInterno = this.listGeneric.computeIfAbsent(getTypeClass(), k -> new HashMap<>());
    }

    @Override
    public Class<Ferrari> getTypeClass() {
        return Ferrari.class;
    }

    @Override
    public void atualizar(Ferrari entity, Ferrari entitycadastrado) {

    }
}
