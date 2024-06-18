package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.models.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchJpaRepository extends JpaRepository<MatchEntity, Long> {

    @Query("SELECT m FROM MatchEntity m WHERE m.player.id = :playerId")
    Optional<List<MatchEntity>> getAllByPlayer(Long playerId);
}
