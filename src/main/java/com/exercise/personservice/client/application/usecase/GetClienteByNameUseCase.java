package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.mapper.ClientMapper;
import com.exercise.personservice.client.application.port.GetClientByNamePort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetClienteByNameUseCase implements GetClientByNamePort {
    @Autowired
    private GetClientRepository getClientRepository;
    @Override
    public ClientResponseDto findByName(String name) {

        Client client = getClientRepository.findByName(name);
       return ClientMapper.clientToClientDto(client);
    }
}
