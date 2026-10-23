package tn.esprim.gestiondefoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

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

    @OneToOne
    private Universite universite;

    @OneToMany(mappedBy = "foyer",cascade = CascadeType.ALL)
    private List<Bloc> blocs;
}