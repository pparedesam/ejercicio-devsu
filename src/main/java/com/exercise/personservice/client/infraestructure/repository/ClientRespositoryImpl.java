package com.exercise.personservice.client.infraestructure.repository;

import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.CreateClientRepository;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientRespositoryImpl implements GetClientRepository, CreateClientRepository {

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        return clientJpaRepository.save(client);
    }
}
