package domain;

import java.util.UUID;
import java.util.Optional;

public interface Repository {

    void save(Bd bd);

    Bd load(UUID id);
}
