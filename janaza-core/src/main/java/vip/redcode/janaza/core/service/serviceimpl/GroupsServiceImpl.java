package vip.redcode.janaza.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vip.redcode.janaza.core.entity.Groups;
import vip.redcode.janaza.core.repository.GroupsRepository;
import vip.redcode.janaza.core.service.GroupsService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GroupsServiceImpl implements GroupsService {

    private GroupsRepository repository;

    @Override
    public List<Groups> findAll() {
        return repository.findAll();
    }

    @Override
    public Groups findById(UUID uuid) {
        return repository.getById(uuid);
    }

    @Override
    public Groups save(Groups groups) {
        return repository.save(groups);
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}
