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
                .setBody("Умер6")
                .build();

        Message message = Message.builder()
                .setNotification(notification)
                .putData("time", "now")
                .setToken("cwVSOgjsQz6AVNTq1HrpPM:APA91bE_7jqowb0lh1kfhIsMAYApc9hzWk6iIVCh5xQQYfWyeg2q6ysnz8JL87sbSjPg4D2Iyir9FzVkV8KbKvfUWPTRLewQddCKxKV5EYM2ELlwGlGaruOaLsipZwP-WrjKSO2fyV5o")
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