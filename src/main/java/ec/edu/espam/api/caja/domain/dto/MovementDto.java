package ec.edu.espam.api.caja.domain.dto;

import ec.edu.espam.api.caja.domain.Movement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovementDto {
    private Long id;

    //@NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private Movement.Type type;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    //@NotNull(message = "Balance is required")
    private BigDecimal balance;

    @NotNull(message = "Account ID is required")
    private Long accountId;
}
