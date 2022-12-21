package vip.redcode.janaza.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vip.redcode.janaza.core.entity.Notification;
import vip.redcode.janaza.core.repository.NotificationRepository;
import vip.redcode.janaza.core.service.NotificationService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository repository;

    @Override
    public List<Notification> findAll() {
        return repository.findAll();
    }

    @Override
    public Notification findById(UUID uuid) {
        return repository.findById(uuid).orElse(null);
    }

    @Override
    public Notification findByToken(String token) {
        return repository.findByToken(token);
    }

    @Override
    public Notification save(Notification notification) {
        Notification notificationFromToken = findByToken(notification.getToken());
        if (notificationFromToken != null) return notificationFromToken;
        return repository.save(notification);
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }
}
