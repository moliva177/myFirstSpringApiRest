package ar.edu.utn.frc.tup.lciii.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialV2 {

    @NotNull(message = "identity can't br null")
    @JsonProperty("identity")
    private String identity;

    @NotNull(message = "password can't br null")
    private String password;
}
