package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {

    Optional<PlayerEntity> findByUserNameOrEmail(String username, String email);

    Optional<PlayerEntity> findByUserNameAndPassword(String username, String password);

    Optional<PlayerEntity> findByEmailAndPassword(String email, String password);

    @Query("SELECT p FROM PlayerEntity p " +
            "WHERE (p.userName = :identity OR p.email = :identity) AND p.password = :password")
    Optional<PlayerEntity> findByUserNameOrEmailAndPassword(@Param("identity") String identity, @Param("password") String password);
}
