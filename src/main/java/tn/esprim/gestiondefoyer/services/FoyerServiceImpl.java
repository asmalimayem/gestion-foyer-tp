package tn.esprim.gestiondefoyer.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entities.Bloc;
import tn.esprim.gestiondefoyer.entities.Foyer;
import tn.esprim.gestiondefoyer.entities.Universite;
import tn.esprim.gestiondefoyer.repositories.BlocRepository;
import tn.esprim.gestiondefoyer.repositories.FoyerRepository;
import tn.esprim.gestiondefoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {

    private FoyerRepository foyerRepository;
    private BlocRepository blocRepository;
    private UniversiteRepository universiteRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId)
                .orElseThrow(() -> new EntityNotFoundException("Foyer introuvable : " + foyerId));
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Transactional
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Université introuvable : " + idUniversite));

        // 1) Sauvegarder le foyer
        Foyer saved = foyerRepository.save(foyer);

        // 2) Affecter les blocs au foyer
        if (saved.getBlocs() != null) {
            for (Bloc b : saved.getBlocs()) {
                b.setFoyer(saved);
            }
            blocRepository.saveAll(saved.getBlocs());
        }

        // 3) Affecter le foyer à l'université
        saved.setUniversite(universite);
        universite.setFoyer(saved);

        return foyerRepository.save(saved);
    }
}