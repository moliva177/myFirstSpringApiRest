package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PlayerJpaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Test
    void findByUserNameOrEmailTest() {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setEmail("email@email.com");
        playerEntity.setUserName("Max");
        playerEntity.setPassword("Password01!");

        entityManager.persist(playerEntity);
        entityManager.flush();

        Optional<PlayerEntity> result = playerJpaRepository.findByUserNameOrEmail("Max", "email@email.com");
        assertEquals("Max", result.get().getUserName());
    }
}