package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.ErrorApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Operation(
            summary = "Check healty of the app",
            description = "If the app is active response pong"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succesful operation", content =
            @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =
            @Content(schema = @Schema(implementation = ErrorApi.class)))
    })
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
