package ec.edu.espam.api.caja.service;

import ec.edu.espam.api.caja.domain.Account;
import ec.edu.espam.api.caja.domain.Movement;
import ec.edu.espam.api.caja.domain.dto.MovementDto;

import java.math.BigDecimal;
import java.util.List;

public interface MovementService {
    MovementDto create(MovementDto dto);

    Movement createCredit(Account account, BigDecimal amount);

    MovementDto update(Long id, MovementDto dto);

    void delete(Long id);

    MovementDto getById(Long id);

    List<MovementDto> getAll(Long accountId);



}
