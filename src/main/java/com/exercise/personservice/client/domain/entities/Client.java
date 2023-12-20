package com.exercise.personservice.client.domain.entities;


import com.exercise.personservice.person.domain.entities.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String password;

    private boolean state;

    @OneToOne
    @JoinColumn(name = "personaId", referencedColumnName = "id")
    private Person person;
}
