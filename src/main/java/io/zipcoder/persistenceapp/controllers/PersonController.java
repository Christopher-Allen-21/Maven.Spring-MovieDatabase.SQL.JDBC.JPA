package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.services.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }

//    {
//        "id": 1,
//            "firstName": "Chris",
//            "lastName": "Allen",
//            "mobile": "240-688-1234",
//            "birthday": "2021-05-15",
//            "homeId": 123
//    }

    //    POST /people -- create a person
    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(service.add(person), HttpStatus.CREATED);
    }


    //    PUT /people/{id} -- update person with id. 404 error if that person doesn't exist yet
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id,Person person){
        return new ResponseEntity<>(service.update(id,person),HttpStatus.OK);
    }

    //    GET /people/{id} -- get the person with the specified ID
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    //    DELETE /people/{id} -- Delete the person with the specified ID
    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.remove(id),HttpStatus.OK);
    }

    //    GET /people -- get all people in the database
    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getAllPeople(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }


    //    GET /people/reverselookup/{mobileNumber} -- find all people with the specified mobile number
    //    GET /people/surname/{lastName} -- Find all people with a particular last name
    //    GET /people/surname -- Get the result of the surname report above
    //    GET /people/firstname/stats -- Get the report of first name frequencies

}
