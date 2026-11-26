package tn.esprim.gestiondefoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;

    private String nomUniversite;
    private String adresse;

    @OneToOne(mappedBy = "universite")
    @JsonIgnore
    private Foyer foyer;
}