package vip.redcode.janaza.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vip.redcode.janaza.core.entity.Person;
import vip.redcode.janaza.core.service.PersonService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    @GetMapping("/{uuid}")
    @PreAuthorize("hasRole('admin') or hasRole('editor') or hasRole('user')")
    public ResponseEntity<Person> getByID(@PathVariable(name = "uuid") UUID uuid) {
        Person person = service.findById(uuid);
        if (person != null) return ResponseEntity.ok().body(person);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok().body(service.save(person));
    }
}
