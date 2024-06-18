package ar.edu.utn.frc.tup.lciii.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "identity_type", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserNameIdentity.class, name = "USERNAME"),
        @JsonSubTypes.Type(value = EmailIdentity.class, name = "Email")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Identity {

    @NotNull(message = "identity_type can't by null")
    @JsonProperty("identity_type")
    private IdentityType identityType;
}
