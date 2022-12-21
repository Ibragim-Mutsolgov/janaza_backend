package vip.redcode.janaza.core.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class NotificationApi {

    private final Logger logger = Logger.getLogger(NotificationApi.class.getName());

    public void sendNotification() throws FirebaseMessagingException, IOException {
        Notification notification = Notification.builder()
                .setTitle("Канцыгов Ибрагим Зурабович")
                .setBody("Умер")
                .build();

        Message message = Message.builder()
                .setNotification(notification)
                .putData("time", "now")
                .setToken("dI4vUz5STMa_pfYQ6hpO9G:APA91bH6-KhqtzRQFCuZOFL_t0Qi7Zif3HCDtYGu0pMgG_hjfPYQZHhFHYwJ3gICapdZLmKaHH5fsSEQfEO-b8cp-N4001Hh8X8pYWmPK9n5b7PgWREzXjHHA6MnaFfiHUJBqOrXCIIq")
                .build();

        FileInputStream serviceAccount = new FileInputStream("janaza-core/src/main/resources/google_credentials.json");
        FirebaseOptions options = new FirebaseOptions
                .Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);

        String response = FirebaseMessaging.getInstance().send(message);
        logger.info(response);
    }
}
