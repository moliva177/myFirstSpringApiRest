package ar.edu.utn.frc.tup.lciii.Controllers;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<PlayerEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(playerJpaRepository.getReferenceById(id));
    }
}
