package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {
}
