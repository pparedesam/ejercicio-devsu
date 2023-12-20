package com.exercise.personservice.client.infraestructure.repository;

import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.CreateClientRepository;
import com.exercise.personservice.client.domain.repository.DeleteClientRepository;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import com.exercise.personservice.client.domain.repository.UpdateClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientRespositoryImpl implements GetClientRepository, CreateClientRepository, UpdateClientRepository, DeleteClientRepository {

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll();
    }

    @Override
    public Client findById(Long idClient) {
        return clientJpaRepository.findById(idClient).orElse(null);
    }

    @Override
    public Client create(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public void deleteById(Long idClient) {
        clientJpaRepository.deleteById(idClient);

    }
}
