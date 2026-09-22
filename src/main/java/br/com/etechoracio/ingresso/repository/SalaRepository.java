package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    @Query("SELECT sala FROM Sala sala WHERE sala.dtExclusao IS NULL")
    List<Sala>buscarSalasAtivas();
}
