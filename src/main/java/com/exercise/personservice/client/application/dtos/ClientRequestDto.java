package com.exercise.personservice.client.application.dtos;

public record ClientRequestDto(
        String name,
        String address,
        String phone,
        String password,
        Boolean state
) {
}
