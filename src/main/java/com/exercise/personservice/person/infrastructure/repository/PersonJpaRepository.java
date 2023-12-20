package com.exercise.personservice.person.infrastructure.repository;

import com.exercise.personservice.person.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person,Long> {

}
