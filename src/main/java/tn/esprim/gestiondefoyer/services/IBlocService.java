package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entities.Bloc;

import java.util.List;

public interface IBlocService {

    List<Bloc> retrieveAllBlocs();
    Bloc retrieveBloc(Long blocId);
    Bloc addBloc(Bloc b);
    void removeBloc(Long blocId);
    Bloc modifyBloc(Bloc bloc);

    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}