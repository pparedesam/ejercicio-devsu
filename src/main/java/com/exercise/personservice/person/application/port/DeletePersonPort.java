package com.exercise.personservice.person.application.port;

import com.exercise.personservice.person.domain.entities.Person;

public interface DeletePersonPort {

    void deleteById(Long idPerson);
}
