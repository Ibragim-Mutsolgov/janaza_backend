package vip.redcode.janaza.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.redcode.janaza.core.entity.Users;
import vip.redcode.janaza.core.service.UsersService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private UsersService service;

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable(name = "id") UUID id) {
        Users users = service.findById(id);
        if (users != null) return ResponseEntity.ok().body(users);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> save(Users users) {
        return ResponseEntity.ok().body(service.save(users));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") UUID id) {
        service.deleteById(id);
    }
}
