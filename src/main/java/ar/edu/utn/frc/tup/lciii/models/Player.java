package ar.edu.utn.frc.tup.lciii.models;

import ar.edu.utn.frc.tup.lciii.utils.validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Long id;

    @NotNull(message = "userName can't be NULL")
    private String userName;

    @NotNull(message = "password can't be NULL")
    @ValidPassword
    private String password;

    @NotNull(message = "email can't be NULL")
    @Email(message = "invalid email")
    private String email;
    private String avatar;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime lastLogin;
}
