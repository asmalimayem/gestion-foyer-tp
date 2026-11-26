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
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;

    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    @JsonIgnore
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Chambre> chambres;
}