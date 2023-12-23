package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.mapper.ClientMapper;
import com.exercise.personservice.client.application.port.GetClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetClientUseCase  implements GetClientPort
{
    @Autowired
    GetClientRepository getClientRepository;

    @Override
    public ClientResponseDto findById(Long idClient) {
        Client client = getClientRepository.findById(idClient);
        return ClientMapper.clientToClientDto(client);
    }
}
