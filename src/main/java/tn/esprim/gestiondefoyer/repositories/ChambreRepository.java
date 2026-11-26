package tn.esprim.gestiondefoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprim.gestiondefoyer.entities.Chambre;
import tn.esprim.gestiondefoyer.entities.ChambreType;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    // Solution 1 : JPQL
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> trouverChambresParBlocAndType(
            @Param("idBloc") Long idBloc,
            @Param("typeC") ChambreType typeC);

    // Solution 2 : Keywords (Spring Data dérive la requête)
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, ChambreType typeC);

    // Chambres d'une université via nomUniversite
    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite")
    List<Chambre> trouverChambreParNomUniversite(@Param("nomUniversite") String nomUniversite);
}