package tn.esprim.gestiondefoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entities.Chambre;
import tn.esprim.gestiondefoyer.entities.ChambreType;
import tn.esprim.gestiondefoyer.services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {

    private IChambreService chambreService;

    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        return chambreService.retrieveChambre(chId);
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreService.addChambre(c);
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }

    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        return chambreService.modifyChambre(c);
    }

    @GetMapping("/getChambreParNomUniversite/{nomUniv}")
    public List<Chambre> getChambreParNomUniversite(@PathVariable("nomUniv") String nomUniversite) {
        return chambreService.getChambreParNomUniversite(nomUniversite);
    }

    @GetMapping("/trouverChambresParBlocAndType/{idBloc}/{typeC}")
    public List<Chambre> trouverChambresParBlocAndType(@PathVariable("idBloc") Long idBloc,
                                                       @PathVariable("typeC") ChambreType typeC) {
        return chambreService.trouverChambresParBlocAndType(idBloc, typeC);
    }
}