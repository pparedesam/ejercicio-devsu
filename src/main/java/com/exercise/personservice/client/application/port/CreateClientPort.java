package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.domain.entities.Client;

public interface CreateClientPort {
    void execute(Client client);
}
