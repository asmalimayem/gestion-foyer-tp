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
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    private String nomFoyer;
    private long capaciteFoyer;

    // Foyer est le child -> côté propriétaire
    @OneToOne
    @JsonIgnore
    private Universite universite;

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Bloc> blocs;
}