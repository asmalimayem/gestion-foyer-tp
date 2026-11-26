package tn.esprim.gestiondefoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entities.Etudiant;
import tn.esprim.gestiondefoyer.repositories.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long etudiantId) {
        return etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable : " + etudiantId));
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void removeEtudiant(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}