package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.port.DeleteClientPort;
import com.exercise.personservice.client.application.port.UpdateClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/client")
public class DeleteClienteController {

    @Autowired
    private DeleteClientPort deleteClientPort;

    @DeleteMapping
    public ResponseEntity deleteClient(@RequestParam("idClient") Long idClient){
        deleteClientPort.deleteById(idClient);
        return ResponseEntity.ok().build();
    }
}
