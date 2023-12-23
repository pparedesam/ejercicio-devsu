package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.port.UpdateClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.UpdateClientRepository;
import com.exercise.personservice.person.application.port.UpdatePersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientUseCase implements UpdateClientPort {

    @Autowired
    private UpdateClientRepository updateClientRepository;

    @Autowired
    private UpdatePersonPort updatePersonPort;
    @Override
    @Transactional
    public Client update(Client client) {
        Person person = updatePersonPort.update(client.getPerson());
        client.setPerson(person);
        return updateClientRepository.update(client);
    }
}
