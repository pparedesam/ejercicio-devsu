package com.exercise.personservice.person.domain.repository;

import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.person.domain.entities.Person;

public interface UpdatePersonRepository {

    Person update(Person person);
}
