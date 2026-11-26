package tn.esprim.gestiondefoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entities.Chambre;
import tn.esprim.gestiondefoyer.entities.ChambreType;
import tn.esprim.gestiondefoyer.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    private ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreID) {
        return chambreRepository.findById(chambreID)
                .orElseThrow(() -> new RuntimeException("Chambre introuvable : " + chambreID));
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreID) {
        chambreRepository.deleteById(chambreID);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambreParNomUniversite(String nomUniversite) {
        return chambreRepository.trouverChambreParNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> trouverChambresParBlocAndType(long idBloc, ChambreType typeC) {
        return chambreRepository.trouverChambresParBlocAndType(idBloc, typeC);
    }
}