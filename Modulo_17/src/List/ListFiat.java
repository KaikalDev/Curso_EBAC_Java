package List;

import List.Generic.ListGeneric;
import List.Interfaces.IListFiat;
import Models.Fiat;

import java.util.HashMap;
import java.util.Map;

public class ListFiat extends ListGeneric<Fiat> implements IListFiat {
    public ListFiat() {
        super();
        Map<String, Fiat> mapaInterno = this.listGeneric.computeIfAbsent(getTypeClass(), k -> new HashMap<>());
    }

    @Override
    public Class<Fiat> getTypeClass() {
        return Fiat.class;
    }

    @Override
    public void atualizar(Fiat entity, Fiat entitycadastrado) {

    }
}
