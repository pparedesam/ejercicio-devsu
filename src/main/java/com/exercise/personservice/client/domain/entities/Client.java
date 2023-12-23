package com.exercise.personservice.client.domain.entities;


import com.exercise.personservice.person.domain.entities.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String password;

    private Boolean state;

    @OneToOne
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person person;
}
