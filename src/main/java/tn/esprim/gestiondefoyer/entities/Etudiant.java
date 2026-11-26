package tn.esprim.gestiondefoyer.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;

    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    // Etudiant est le child -> côté propriétaire
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reservation> reservations;
}