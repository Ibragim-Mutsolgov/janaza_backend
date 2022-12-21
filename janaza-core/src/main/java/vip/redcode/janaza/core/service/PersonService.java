package vip.redcode.janaza.core.service;

import vip.redcode.janaza.core.entity.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    List<Person> findAll();

    Person findById(UUID uuid);

    Person save(Person person);

    void deleteById(UUID uuid);
}
