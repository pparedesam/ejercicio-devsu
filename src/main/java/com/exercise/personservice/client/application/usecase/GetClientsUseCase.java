package com.exercise.personservice.client.application.usecase;


import com.exercise.personservice.client.application.port.GetClientsPort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetClientsUseCase implements GetClientsPort {

    @Autowired
    private GetClientRepository getClientRepository;

    @Override
    public List<Client> execute() {
        return getClientRepository.findAll();
    }


}
