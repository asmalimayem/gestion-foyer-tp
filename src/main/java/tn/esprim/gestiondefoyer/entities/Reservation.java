package tn.esprim.gestiondefoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    @Id
    private String idReservation;

    private String anneeUniversitaire;
    private boolean estValide;

    // Côté inverse -> mappedBy côté Etudiant
    @ManyToMany(mappedBy = "reservations", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Etudiant> etudiants;
}