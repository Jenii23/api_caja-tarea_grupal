package ec.edu.espam.api.caja.domain.dto;

import ec.edu.espam.api.caja.domain.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {

    private Long id;

    @NotEmpty(message = "Number is required")
    private String number;

    @NotNull(message = "Type account is required")
    @Enumerated(EnumType.STRING)
    private Account.Type type;

    //@NotNull(message = "Initial Balance is required")
    private BigDecimal initialBalance;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    @NotNull(message = "State is required")
    private Boolean state;

    @NotNull(message = "Client is required")
    private Long clientId;
}
