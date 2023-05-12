package domain;

import io.netty.util.internal.StringUtil;

import java.util.Collections;
import java.util.Set;

public record Proprietaire(String name) {

    private static Set<String> proprietaires = Collections.unmodifiableSet(Set.of("Quentin", "Camille", "Karim"));

    public Proprietaire {
        if (StringUtil.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Le nom du propriétaire ne peut pas être null ou vide");
        }
        if (!proprietaires.contains(name)) {
            throw new IllegalArgumentException("Le propriétaire ne fait pas partie de la classe");
        }
    }
}
