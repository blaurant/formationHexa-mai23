package domain;

import java.util.Objects;
import java.util.UUID;

@ddd.Entity()
public class Bd {

    public enum State {DISPONIBLE,EMPRUNTE};

    public final UUID id;
    public State state;

    public final Isbn isbn;
    public final Proprietaire proprietaire;

    public Bd(UUID id, Isbn isbn, Proprietaire proprietaire) {
        this.id = checkNotNull(id, "id is null");
        this.isbn = checkNotNull(isbn, "isbn is null");
        this.proprietaire = checkNotNull(proprietaire, "proprietaire is null");
        this.state = State.DISPONIBLE;
    }

    private static <T> T checkNotNull(T t, String msg) {
        if (t == null)
            throw new IllegalArgumentException(msg);
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bd)) return false;
        Bd bd = (Bd) o;
        return id.equals(bd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ddd.Command
    public void emprunter() {
        if (Bd.State.DISPONIBLE.equals(state)) {
            this.state = State.EMPRUNTE;
        }

    }
}
