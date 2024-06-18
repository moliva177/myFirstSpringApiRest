package ar.edu.utn.frc.tup.lciii.models;

import ar.edu.utn.frc.tup.lciii.utils.validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "myUserName")
    @NotNull(message = "userName can't be NULL")
    private String userName;

    @Schema(example = "Password0!")
    @NotNull(message = "password can't be NULL")
    @ValidPassword
    private String password;

    @Schema(example = "email@email.com")
    @NotNull(message = "email can't be NULL")
    @Email(message = "invalid email")
    private String email;

    @Schema(example = "http://localhost:8080/avatars/myUserName")
    private String avatar;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime lastLogin;
}
