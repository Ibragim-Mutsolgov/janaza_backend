package vip.redcode.janaza.core;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.redcode.janaza.core.entity.Notification;
import vip.redcode.janaza.core.firebase.NotificationApi;

import java.io.IOException;

@SpringBootApplication
public class JanazaApplication {

    public static void main(String[] args) throws IOException, FirebaseMessagingException {
        SpringApplication.run(JanazaApplication.class, args);
        NotificationApi notification = new NotificationApi();
        notification.sendNotification();
    }
}
