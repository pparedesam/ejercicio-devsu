package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.domain.entities.Client;

import java.util.List;

public interface GetClientPort {
    List<Client> execute();
}
