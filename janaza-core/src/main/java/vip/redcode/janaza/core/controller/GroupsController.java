package vip.redcode.janaza.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vip.redcode.janaza.core.entity.Groups;
import vip.redcode.janaza.core.service.GroupsService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/groups")
public class GroupsController {

    private GroupsService service;

    @GetMapping
    public ResponseEntity<List<Groups>> getAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Groups> getById(@PathVariable(name = "uuid") UUID uuid) {
        Groups groups = service.findById(uuid);
        if (groups != null) return ResponseEntity.ok().body(groups);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Groups> save(@RequestBody Groups groups) {
        return ResponseEntity.ok().body(service.save(groups));
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "uuid") UUID uuid) {
        service.deleteById(uuid);
    }
}
