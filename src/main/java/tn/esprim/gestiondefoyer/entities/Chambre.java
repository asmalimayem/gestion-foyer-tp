package tn.esprim.gestiondefoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private ChambreType typeC;

    @ManyToOne
    @JsonIgnore
    private Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reservation> reservations;
}