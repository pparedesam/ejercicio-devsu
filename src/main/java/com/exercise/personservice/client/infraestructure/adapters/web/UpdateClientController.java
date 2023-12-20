package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.port.UpdateClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/client")
public class UpdateClientController {


    @Autowired
    private UpdateClientPort updateClientPort;

    @PutMapping
    public ResponseEntity updateClient(@RequestBody Client client){
        Client clientResponse = updateClientPort.update(client);
        return ResponseEntity.ok(clientResponse);
    }
}
