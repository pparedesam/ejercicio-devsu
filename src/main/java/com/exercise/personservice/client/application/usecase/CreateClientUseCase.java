package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.mapper.ClientMapper;
import com.exercise.personservice.client.application.port.CreateClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.CreateClientRepository;
import com.exercise.personservice.person.application.port.CreatePersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase implements CreateClientPort {

    @Autowired
    private CreateClientRepository createClientRepository;

    @Autowired
    private CreatePersonPort createPersonPort;



    @Override
    @Transactional
    public void execute(ClientRequestDto clientRequestDto) {

        Client client = ClientMapper.clientDtoToClient(clientRequestDto);

        Person person = createPersonPort.execute(client.getPerson());
        client.setPerson(person);
        createClientRepository.create(client);
    }
}
