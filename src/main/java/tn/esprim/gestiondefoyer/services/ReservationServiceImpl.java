package tn.esprim.gestiondefoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprim.gestiondefoyer.entities.Reservation;
import tn.esprim.gestiondefoyer.repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable : " + idReservation));
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // --- Slides 17/18 : implémentations à venir ---
    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        throw new UnsupportedOperationException("À implémenter (slide 17)");
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        throw new UnsupportedOperationException("À implémenter (slide 18)");
    }
}