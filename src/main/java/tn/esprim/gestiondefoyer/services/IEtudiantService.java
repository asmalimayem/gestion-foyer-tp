package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant retrieveEtudiant(Long etudiantId);

    Etudiant addEtudiant(Etudiant e);

    void removeEtudiant(Long etudiantId);

    Etudiant modifyEtudiant(Etudiant etudiant);
}
