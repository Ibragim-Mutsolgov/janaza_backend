package vip.redcode.janaza.core.service;

import vip.redcode.janaza.core.entity.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService {

    List<Notification> findAll();

    Notification findById(UUID uuid);

    Notification findByToken(String token);

    Notification save(Notification notification);

    void deleteById(UUID uuid);
}
