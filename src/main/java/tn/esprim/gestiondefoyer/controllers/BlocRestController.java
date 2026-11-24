package tn.esprim.gestiondefoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entities.Bloc;
import tn.esprim.gestiondefoyer.services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    private IBlocService blocService;

    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() { return blocService.retrieveAllBlocs(); }

    @GetMapping("/retrieve-bloc/{blocId}")
    public Bloc retrieveBloc(@PathVariable Long blocId) { return blocService.retrieveBloc(blocId); }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) { return blocService.addBloc(b); }

    @DeleteMapping("/remove-bloc/{blocId}")
    public void removeBloc(@PathVariable Long blocId) { blocService.removeBloc(blocId); }

    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) { return blocService.modifyBloc(b); }
}