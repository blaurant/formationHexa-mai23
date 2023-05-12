package infrastructure.rest;

import application.BdService;
import application.EnregistrementBdCmd;
import domain.Bds;
import domain.Isbn;
import domain.Proprietaire;

import java.util.UUID;

public class BdAdaptor {
    
    private final BdService bdService;
    
    public BdAdaptor(BdService bdService){
        this.bdService = bdService;
    }

    public EnregistrementBdCmd adapt(String idStr, EnregistrementBdDto enregistrementBdDto) {
        UUID id = UUID.fromString(idStr);
        Proprietaire proprietaire = new Proprietaire(enregistrementBdDto.proprietaire());
        Isbn isbn = new Isbn(enregistrementBdDto.isbn());
        return new EnregistrementBdCmd(id, isbn, proprietaire);
    }
}
