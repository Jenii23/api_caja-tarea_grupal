package ec.edu.espam.api.caja.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonDto {

    private Long id;

    @NotEmpty(message = "Dni is required")
    private String dni;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Gender is required")
    private String gender;

    @NotEmpty(message = "address is required")
    private String address;

    @NotEmpty(message = "Phone is required")
    private String phone;

    @NotNull(message = "Age is required")
    private Integer age;
}
