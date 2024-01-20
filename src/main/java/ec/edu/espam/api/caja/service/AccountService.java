package ec.edu.espam.api.caja.service;

import ec.edu.espam.api.caja.domain.Account;
import ec.edu.espam.api.caja.domain.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAll();

    AccountDto create(AccountDto dto);

    AccountDto getById(Long id);

    AccountDto update(Long id, AccountDto dto);

    void delete(Long id);
}
