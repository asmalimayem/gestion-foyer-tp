package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entities.Reservation;

import java.util.List;

public interface IReservationService {

    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(String idReservation);
    Reservation addReservation(Reservation r);
    void removeReservation(String idReservation);
    Reservation modifyReservation(Reservation reservation);

    // Pour le slide 17 & 18 (à implémenter plus tard)
    Reservation ajouterReservation(long idBloc, long cinEtudiant);
    Reservation annulerReservation(long cinEtudiant);
}