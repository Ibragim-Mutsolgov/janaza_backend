package vip.redcode.janaza.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vip.redcode.common.core.repository.PeopleRepository;
import vip.redcode.janaza.core.entity.Users;
import vip.redcode.janaza.core.repository.UsersRepository;
import vip.redcode.janaza.core.service.UsersService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private UsersRepository repository;

    private PeopleRepository peopleRepository;

    @Override
    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Users save(Users users) {
        return repository.save(users);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
