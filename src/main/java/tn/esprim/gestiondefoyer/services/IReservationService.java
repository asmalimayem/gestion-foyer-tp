package tn.esprim.gestiondefoyer.services;

import tn.esprim.gestiondefoyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();

    Reservation retrieveReservation(Long reservationId);

    Reservation addReservation(Reservation r);

    void removeReservation(Long reservationId);

    Reservation modifyReservation(Reservation reservation);
}
