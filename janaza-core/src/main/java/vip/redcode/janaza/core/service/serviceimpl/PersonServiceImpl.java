package vip.redcode.janaza.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vip.redcode.janaza.core.entity.Person;
import vip.redcode.janaza.core.repository.PersonRepository;
import vip.redcode.janaza.core.service.PersonService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person findById(UUID uuid) {
        return repository.findById(uuid).orElse(null);
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}
