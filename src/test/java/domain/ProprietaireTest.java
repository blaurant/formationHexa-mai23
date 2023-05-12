package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProprietaireTest {

    @Test
    public void nullProprietaire() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Proprietaire(null);});
    }

    @Test
    public void invalideProprietaire() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Proprietaire("");});
    }

    @Test
    public void valideProprietaire() {
        Assertions.assertEquals("Quentin", new Proprietaire("Quentin").name());
    }

}
