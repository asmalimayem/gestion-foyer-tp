package tn.esprim.gestiondefoyer.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entities.Bloc;
import tn.esprim.gestiondefoyer.entities.Chambre;
import tn.esprim.gestiondefoyer.repositories.BlocRepository;
import tn.esprim.gestiondefoyer.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {

    private BlocRepository blocRepository;
    private ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId)
                .orElseThrow(() -> new EntityNotFoundException("Bloc introuvable : " + blocId));
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new EntityNotFoundException("Bloc introuvable : " + idBloc));

        for (Long num : numChambre) {
            Chambre chambre = chambreRepository.findAll().stream()
                    .filter(c -> c.getNumeroChambre() == num)
                    .findFirst()
                    .orElseThrow(() -> new EntityNotFoundException("Chambre n° " + num + " introuvable"));
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return bloc;
    }
}