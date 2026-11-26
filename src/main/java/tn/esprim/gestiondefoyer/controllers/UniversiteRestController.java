package tn.esprim.gestiondefoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entities.Universite;
import tn.esprim.gestiondefoyer.services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    private IUniversiteService universiteService;

    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    @GetMapping("/retrieve-universite/{universiteId}")
    public Universite retrieveUniversite(@PathVariable Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @DeleteMapping("/remove-universite/{universiteId}")
    public void removeUniversite(@PathVariable Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }

    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return universiteService.modifyUniversite(universite);
    }

    @PutMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable("idFoyer") Long idFoyer,
                                               @PathVariable("nomUniversite") String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecterFoyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable("idUniversite") Long idUniversite) {
        return universiteService.desaffecterFoyerUniversite(idUniversite);
    }
}