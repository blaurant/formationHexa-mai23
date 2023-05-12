package application;

import domain.Bd;
import domain.Bds;
import domain.Isbn;
import domain.Proprietaire;
import domain.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class BdServiceTest {

    @Test
    void something() {
        Repository repo = new Repository() {

            Bds bds = new Bds();

            @Override
            public void save(Bd bd) {
                bds = bds.add(bd);
            }

            @Override
            public Bd load(UUID id) {
                return bds.byId(id);
            }
        };

        // GIVEN
        UUID id = UUID.randomUUID();
        Proprietaire proprietaire = new Proprietaire("Quentin");
        Isbn isbn = new Isbn("978-2012101333");
        //WHEN
        BdService bdService = new BdService(repo);
        bdService.enregistrer(id, isbn, proprietaire);
        //THEN
        Bd bd = bdService.byId(id);
        Assertions.assertEquals(id, bd.id);
        Assertions.assertEquals(Bd.State.DISPONIBLE, bd.state);
        Assertions.assertEquals(proprietaire, bd.proprietaire);

    }
}
