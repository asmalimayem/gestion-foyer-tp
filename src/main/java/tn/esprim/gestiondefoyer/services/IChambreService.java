package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entities.Chambre;
import tn.esprim.gestiondefoyer.entities.ChambreType;

import java.util.List;

public interface IChambreService {

    List<Chambre> retrieveAllChambres();
    Chambre retrieveChambre(Long chambreID);
    Chambre addChambre(Chambre c);
    void removeChambre(Long chambreID);
    Chambre modifyChambre(Chambre chambre);

    List<Chambre> getChambreParNomUniversite(String nomUniversite);
    List<Chambre> trouverChambresParBlocAndType(long idBloc, ChambreType typeC);
}