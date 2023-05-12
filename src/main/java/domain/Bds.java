package domain;

import io.vavr.collection.List;

import java.util.UUID;

public class Bds {

    List<Bd> listBd = List.of();

    public Bds add(Bd bd) {
        listBd = listBd.append(bd);
        return this;
    }

    public Bd byId(UUID id) {
        return listBd.filter(bd -> bd.id.equals(id)).head();
    }
}
