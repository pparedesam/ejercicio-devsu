package com.exercise.personservice.person.infrastructure.repository;

import com.exercise.personservice.person.domain.entities.Person;
import com.exercise.personservice.person.domain.repository.CreatePersonRepository;
import com.exercise.personservice.person.domain.repository.DeletePersonRepository;
import com.exercise.personservice.person.domain.repository.GetPersonRepository;
import com.exercise.personservice.person.domain.repository.UpdatePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRespositoryImpl implements GetPersonRepository, CreatePersonRepository, UpdatePersonRepository, DeletePersonRepository {

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Override
    public List<Person> findAll() {
        return personJpaRepository.findAll();
    }

    @Override
    public Person create(Person person) {
        return personJpaRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return personJpaRepository.save(person);
    }

    @Override
    public void deleteById(Long personId) {
        personJpaRepository.deleteById(personId);
    }
}
