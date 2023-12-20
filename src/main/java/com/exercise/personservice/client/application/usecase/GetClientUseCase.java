package com.exercise.personservice.client.application.usecase;


import com.exercise.personservice.client.application.port.GetClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetClientUseCase implements GetClientPort {

    @Autowired
    private GetClientRepository getClientRepository;

    @Override
    public List<Client> execute() {
        return getClientRepository.findAll();
    }
}
