package List;

import List.Generic.ListGeneric;
import List.Interfaces.IListLamborghini;
import Models.Lamborghini;

import java.util.HashMap;
import java.util.Map;

public class ListLamborghini extends ListGeneric<Lamborghini> implements IListLamborghini {
    public ListLamborghini() {
        super();
        Map<String, Lamborghini> mapaInterno = this.listGeneric.computeIfAbsent(getTypeClass(), k -> new HashMap<>());
    }

    @Override
    public Class<Lamborghini> getTypeClass() {
        return null;
    }

    @Override
    public void atualizar(Lamborghini entity, Lamborghini entitycadastrado) {

    }
}
