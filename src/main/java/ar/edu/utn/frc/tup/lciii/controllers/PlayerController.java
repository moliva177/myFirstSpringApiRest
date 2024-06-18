package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.ErrorApi;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @Operation(
            summary = "save a player in the plataform",
            description = "Return the player saved if the fields are correct"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succesful operation", content =
            @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "The fields are invalid", content =
            @Content(schema = @Schema(implementation = ErrorApi.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
            @Content(schema = @Schema(implementation = ErrorApi.class)))
    })
    @PostMapping("")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player) {
        Player playerSaved = playerService.savePlayer(player);
        if (Objects.isNull(playerSaved)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or email already exists");
        }
        else{
            return ResponseEntity.ok(playerSaved);
        }
    }
}
