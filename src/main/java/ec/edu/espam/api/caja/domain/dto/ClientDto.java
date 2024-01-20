package ec.edu.espam.api.caja.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDto extends PersonDto {
    @NotEmpty(message = "Password is required")
    @Size(min = 4, message = "Password must have at least 4 characters")
    private String password;

    @NotNull(message = "State is required")
    private Boolean state;
}
