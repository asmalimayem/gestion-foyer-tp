package tn.esprim.gestiondefoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entities.Etudiant;
import tn.esprim.gestiondefoyer.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {

    private IEtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() { return etudiantService.retrieveAllEtudiants(); }

    @GetMapping("/retrieve-etudiant/{etudiantId}")
    public Etudiant retrieveEtudiant(@PathVariable Long etudiantId) { return etudiantService.retrieveEtudiant(etudiantId); }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) { return etudiantService.addEtudiant(e); }

    @DeleteMapping("/remove-etudiant/{etudiantId}")
    public void removeEtudiant(@PathVariable Long etudiantId) { etudiantService.removeEtudiant(etudiantId); }

    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) { return etudiantService.modifyEtudiant(e); }
}