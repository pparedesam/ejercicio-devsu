package com.exercise.personservice.client.infraestructure.adapters.web;

import com.exercise.personservice.client.application.port.DeleteClientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
