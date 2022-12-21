package vip.redcode.janaza.core.service;

import vip.redcode.janaza.core.entity.Groups;

import java.util.List;
import java.util.UUID;

public interface GroupsService {

    List<Groups> findAll();

    Groups findById(UUID uuid);

    Groups save(Groups groups);

    void deleteById(UUID uuid);
}
