package tn.esprim.gestiondefoyer.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entities.Foyer;
import tn.esprim.gestiondefoyer.entities.Universite;
import tn.esprim.gestiondefoyer.repositories.FoyerRepository;
import tn.esprim.gestiondefoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    private UniversiteRepository universiteRepository;
    private FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long universiteId) {
        return universiteRepository.findById(universiteId)
                .orElseThrow(() -> new EntityNotFoundException("Université introuvable : " + universiteId));
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Transactional
    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new EntityNotFoundException("Foyer introuvable : " + idFoyer));
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Université introuvable : " + nomUniversite));

        if (foyer.getUniversite() != null) {
            throw new IllegalStateException("Le foyer " + foyer.getNomFoyer() + " est déjà affecté à une université");
        }
        if (universite.getFoyer() != null) {
            throw new IllegalStateException("L'université " + nomUniversite + " a déjà un foyer");
        }

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        return universite;
    }

    @Transactional
    @Override
    public Universite desaffecterFoyerUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Université introuvable : " + idUniversite));

        if (universite.getFoyer() == null) {
            throw new IllegalStateException("Aucun foyer associé à l'université : " + idUniversite);
        }

        Foyer foyer = universite.getFoyer();
        foyer.setUniversite(null);      // nettoyer côté Foyer
        universite.setFoyer(null);      // nettoyer côté Universite
        return universite;
    }
}