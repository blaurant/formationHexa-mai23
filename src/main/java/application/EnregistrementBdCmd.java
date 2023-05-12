package application;

import domain.Isbn;
import domain.Proprietaire;

import java.util.UUID;

public class EnregistrementBdCmd implements Runnable {

    BdService bdService;

    private final UUID id;
    private final Isbn isbn;
    private final Proprietaire proprietaire;

    public EnregistrementBdCmd(UUID id, Isbn isbn, Proprietaire proprietaire) {
        this.id = id;
        this.isbn = isbn;
        this.proprietaire = proprietaire;
    }

    public EnregistrementBdCmd inject(BdService bdService) {
        this.bdService = bdService;
        return this;
    }

    @Override
    public void run() {
        bdService.enregistrer(id, isbn, proprietaire);
    }
}
