package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sun.awt.PeerEvent;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class PersonService {

    PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }


    public Iterable<Person> getAll(){
        return repository.findAll();
    }

    //    Add a Person to the database
    public Boolean add(Person person){
        repository.save(person);
        return true;
    }

    //    Update an existing Person in the database
    public Boolean update(@PathVariable Integer id, Person person){
        Person temp = repository.findOne(id);
        temp.setFirstName(person.getFirstName());
        temp.setLastName(person.getLastName());
        temp.setMobile(person.getMobile());
        temp.setBirthday(person.getBirthday());
        temp.setHomeId(person.getHomeId());
        return true;
    }

    //    Remove a person from the database
    public Boolean remove(@PathVariable Integer id){
        repository.delete(id);
        return true;
    }

    //    remove a list of people from the database
    public Boolean removeList(List<Person> personList){
        repository.delete(personList);
        return true;
    }

    //    find all people with a particular first name
    public List<Person> getByFirstName(String firstName){
        List<Person> personList = new ArrayList<>();
        for(Person p : repository.findAll()){
            if(p.getFirstName().equals(firstName)){
                personList.add(p);
            }
        }
        return personList;
    }

    //    find all people with a particular last name
    public List<Person> getByLastName(String lastName){
        List<Person> personList = new ArrayList<>();
        for(Person p : repository.findAll()){
            if(p.getLastName().equals(lastName)){
                personList.add(p);
            }
        }
        return personList;
    }

    //    find all people with a particular birthdate
    public List<Person> getByBirthdate(Date birthdate){
        List<Person> personList = new ArrayList<>();
        for(Person p : repository.findAll()){
            if(p.getBirthday().equals(birthdate)){
                personList.add(p);
            }
        }
        return personList;
    }

    //    Find a single person by ID
    public Person getById(@PathVariable Integer id){
        return repository.findOne(id);
    }

    //    Generate a map of surnames to lists of people with that surname
    public Map<String,List<Person>> getLastNameMap(){
        HashMap<String, List<Person>> lastNameMap = new HashMap<>();
        for(Person p : repository.findAll()){
            if(!lastNameMap.containsKey(p.getLastName())){
                lastNameMap.put(p.getLastName(),new ArrayList<Person>());
            }
            lastNameMap.get(p.getLastName()).add(p);
        }
        return lastNameMap;
    }

    //    Generate a map of first names to the number of times they occur
    public Map<String,Integer> getFirstNameMap(){
        Map<String, Integer> firstNameMap = new HashMap<>();
        for(Person p : repository.findAll()){
            if(!firstNameMap.containsKey(p.getFirstName())){
                firstNameMap.put(p.getFirstName(),1);
            }
            else{
                firstNameMap.put(p.getFirstName(),firstNameMap.get(p.getFirstName()+1));
            }
        }
        return firstNameMap;
    }

}
