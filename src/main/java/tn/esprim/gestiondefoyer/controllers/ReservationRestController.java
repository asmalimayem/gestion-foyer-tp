package tn.esprim.gestiondefoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestiondefoyer.entities.Reservation;
import tn.esprim.gestiondefoyer.services.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private IReservationService reservationService;

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();
    }

    @GetMapping("/retrieve-reservation/{reservationId}")
    public Reservation retrieveReservation(@PathVariable String reservationId) {
        return reservationService.retrieveReservation(reservationId);
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    @DeleteMapping("/remove-reservation/{reservationId}")
    public void removeReservation(@PathVariable String reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        return reservationService.modifyReservation(r);
    }
}