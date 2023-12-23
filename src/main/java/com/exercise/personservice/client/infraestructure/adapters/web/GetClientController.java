package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.port.GetClientByNamePort;
import com.exercise.personservice.client.application.port.GetClientPort;
import com.exercise.personservice.client.application.port.GetClientsPort;
import com.exercise.personservice.client.domain.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
public class GetClientController {

    @Autowired
    private GetClientsPort getClientsPort;

    @Autowired
    private GetClientPort getClientPort;

    @Autowired
    private GetClientByNamePort getClientByNamePort;

    @GetMapping()
    public ResponseEntity<List<Client>>  getClients(){
        List<Client> clients = getClientsPort.execute();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto>  getClientById(@PathVariable("id") Long id){

        ClientResponseDto client = getClientPort.findById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/name")
    public ResponseEntity<ClientResponseDto>getClientByName(@RequestParam("name") String name){

        ClientResponseDto client = getClientByNamePort.findByName(name);
        return ResponseEntity.ok(client);
    }

}
