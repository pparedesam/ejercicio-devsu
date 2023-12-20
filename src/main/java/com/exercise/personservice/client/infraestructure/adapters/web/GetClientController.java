package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.port.GetClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class GetClientController {

    @Autowired
    private GetClientPort getClientPort;

    @GetMapping()
    public ResponseEntity<List<Client>>  getClients(){
        List<Client> clients = getClientPort.execute();
        return ResponseEntity.ok(clients);
    }

}
