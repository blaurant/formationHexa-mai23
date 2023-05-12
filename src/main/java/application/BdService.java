package application;

import domain.Bd;
import domain.Isbn;
import domain.Proprietaire;
import domain.Repository;

import java.util.UUID;

public class BdService {

    Repository repository;

    public BdService(Repository repository) {
        this.repository = repository;
    }

    @ddd.Scenario
    public void enregistrer(UUID id, Isbn isbn, Proprietaire proprietaire) {
        Bd bd = new Bd(id, isbn, proprietaire);
        repository.save(bd);
    }

    public Bd byId(UUID id) {
        return repository.load(id);
    }
}
