package vip.redcode.janaza.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.redcode.janaza.core.entity.Notification;
import vip.redcode.janaza.core.service.NotificationService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private NotificationService service;

    @GetMapping
    public ResponseEntity<List<Notification>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Notification> findById(@PathVariable(name = "uuid") UUID uuid) {
        Notification notification = service.findById(uuid);
        if (notification != null) return ResponseEntity.ok().body(notification);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<Notification> findByToken(@PathVariable(name = "token") String token) {
        Notification notification = service.findByToken(token);
        if (notification != null) return ResponseEntity.ok().body(notification);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Notification> save(@RequestBody Notification notification) {
        return ResponseEntity.ok().body(service.save(notification));
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "uuid") UUID uuid) {
        service.deleteById(uuid);
    }
}
