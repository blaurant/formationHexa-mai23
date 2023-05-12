package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsbnTest {

    @Test
    public void nullIsbn() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Isbn(null);});
    }

    @Test
    public void invalideIsbn() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Isbn("");});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Isbn("pas_bon");});
    }

    @Test
    public void valideIsbn() {
        Assertions.assertEquals("978-2012101333", new Isbn("978-2012101333").isbn());
    }

}
