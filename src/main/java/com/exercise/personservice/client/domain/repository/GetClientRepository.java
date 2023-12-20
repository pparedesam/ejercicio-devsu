package com.exercise.personservice.client.domain.repository;

import com.exercise.personservice.client.domain.entities.Client;

import java.util.List;

public interface GetClientRepository {
    List<Client> findAll();
}
