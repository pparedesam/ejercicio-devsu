package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;

public interface GetClientByNamePort {

    ClientResponseDto findByName(String name);
}
