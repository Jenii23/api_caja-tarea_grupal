package ec.edu.espam.api.caja.service;

import ec.edu.espam.api.caja.domain.Client;
import ec.edu.espam.api.caja.domain.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto create(ClientDto dto);

    List<ClientDto> getAll();

    ClientDto getById(Long id);

    ClientDto update(Long id, ClientDto dto);

    void delete(Long id);

    Client getEntityById(Long id);
}
