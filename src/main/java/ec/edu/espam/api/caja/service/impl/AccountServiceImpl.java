package ec.edu.espam.api.caja.service.impl;

import ec.edu.espam.api.caja.domain.Account;
import ec.edu.espam.api.caja.domain.Client;
import ec.edu.espam.api.caja.domain.dto.AccountDto;
import ec.edu.espam.api.caja.exceptions.EntityNotFoundException;
import ec.edu.espam.api.caja.repository.AccountRepository;
import ec.edu.espam.api.caja.service.AccountService;
import ec.edu.espam.api.caja.service.ClientService;
import ec.edu.espam.api.caja.service.MovementService;
import ec.edu.espam.api.caja.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ClientService clientService;
    private final MovementService movementService;

    @Override
    public List<AccountDto> getAll() {
        return repository.findAll().stream().map(this::convertEntityToDto).toList();
    }

    @Override
    public AccountDto create(AccountDto dto) {
        dto.setInitialBalance(dto.getAmount());
        Account account = convertDtoToEntity(dto);
        account = repository.save(account);

        movementService.createCredit(account, dto.getAmount());

        return convertEntityToDto(account);
    }

    @Override
    public AccountDto getById(Long id) {
        return convertEntityToDto(getEntityById(id));
    }

    @Override
    public AccountDto update(Long id, AccountDto dto) {
        Account account = getEntityById(id);
        Client client = clientService.getEntityById(dto.getClientId());
        account.setClient(client);
        account.setNumber(dto.getNumber());
        account.setAmount(dto.getAmount());
        account.setInitialBalance(dto.getInitialBalance());
        account.setState(dto.getState());
        account.setType(dto.getType());
        return convertEntityToDto(repository.save(account));
    }

    @Override
    public void delete(Long id) {
        Account account = getEntityById(id);
        repository.delete(account);
    }

    private Account getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
    }

    private AccountDto convertEntityToDto(Account account) {
        return Mapper.modelMapper().map(account, AccountDto.class);
    }

    private Account convertDtoToEntity(AccountDto dto) {
        return Mapper.modelMapper().map(dto, Account.class);
    }

}
