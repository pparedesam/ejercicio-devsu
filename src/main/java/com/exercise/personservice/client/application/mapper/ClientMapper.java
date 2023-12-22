package com.exercise.personservice.client.application.mapper;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.person.domain.entities.Person;

public class ClientMapper {
    public static Client clientDtoToClient(ClientRequestDto dto){
        return Client.builder()
                .state(dto.state())
                .password(dto.password())
                .person(Person.builder()
                        .address(dto.address())
                        .name(dto.name())
                        .phone(dto.phone())
                        .build())
                .build();
    }

    public static ClientResponseDto clientToClientDto(Client client) {

        return new ClientResponseDto(
                client.getId(),
                client.getPerson().getName(),
                client.getPerson().getAddress(),
                client.getPerson().getPhone()
        );
    }

}
