package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.port.CreateClientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/client")
public class CreateClientController {
    @Autowired
    private CreateClientPort createClientPort;

    @PostMapping()
    public ResponseEntity createClient(@RequestBody ClientRequestDto clientRequestDto){
        createClientPort.execute(clientRequestDto);
        return ResponseEntity.ok().build();
    }
}
