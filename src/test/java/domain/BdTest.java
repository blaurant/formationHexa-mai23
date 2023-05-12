package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class BdTest {

    @Test
    public void invariantsBD() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Bd(null, null, null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Bd(UUID.randomUUID(), null, new Proprietaire("Quentin")));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Bd(null, new Isbn("978-2012101333"), new Proprietaire("Quentin")));
    }

    @Test
    public void valideBD() {
        Proprietaire proprietaire = new Proprietaire("Quentin");
        Isbn isbn = new Isbn("978-2012101333");
        UUID id = UUID.randomUUID();

        Bd bd = new Bd(id, isbn, proprietaire);

        Assertions.assertEquals(id, bd.id);
        Assertions.assertEquals(proprietaire.name(), bd.proprietaire.name());
        Assertions.assertEquals(isbn.isbn(), bd.isbn.isbn());

    }
}
