package org.example.Repository;

import org.example.Model.Human;
import org.example.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, Human> {

    List<Person> findPersonByCityOfLiving(String city);

    List<Person> findPersonByAge(Integer age);

    Optional<Person> findPersonByFullName(String name, String surname);

}