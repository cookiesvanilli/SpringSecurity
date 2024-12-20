package org.example.Controller;

import lombok.AllArgsConstructor;
import org.example.Model.Person;
import org.example.Repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class Controller {

    private final Repository repository;


    @GetMapping("/persons/by-city")
    protected List<Person> findPersonByCityOfLiving(@RequestParam(value = "city", required = false) String city) {
        return repository.findPersonByCityOfLiving(city);
    }
    @GetMapping("/persons/by-age")
    protected List<Person> findPersonByAge(@RequestParam(value = "age", required = false) Integer age){
        return repository.findPersonByAge(age);
    }

    @GetMapping("/persons/by-fullname")
    protected Optional<Person> findPersonByFullName(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname){
        return repository.findPersonByFullName(name, surname);
    }

}