package tn.esprim.gestiondefoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprim.gestiondefoyer.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
}