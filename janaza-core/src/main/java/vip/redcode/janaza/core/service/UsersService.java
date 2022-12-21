package vip.redcode.janaza.core.service;

import vip.redcode.janaza.core.entity.Users;

import java.util.List;
import java.util.UUID;

public interface UsersService {

    List<Users> findAll();

    Users findById(UUID id);

    Users save(Users users);

    void deleteById(UUID id);
}
