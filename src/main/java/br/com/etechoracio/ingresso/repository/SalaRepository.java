package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    @Query("SELECT sala FROM Sala sala WHERE sala.dtExclusao IS NULL")
    List<Sala>buscarSalasAtivas();

    @Query("SELECT sala FROM Sala sala WHERE sala.id = :id AND sala.dtExclusao IS NULL")
    Optional<Sala> buscarSalaAtivaPorId(@Param("id") Long id);
}
