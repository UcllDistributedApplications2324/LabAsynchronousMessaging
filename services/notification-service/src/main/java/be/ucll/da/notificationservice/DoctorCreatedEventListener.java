package be.ucll.da.notificationservice;

import be.ucll.da.notificationservice.client.doctor.api.model.DoctorCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DoctorCreatedEventListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(DoctorCreatedEventListener.class);

    @RabbitListener(queues = {"q.doctor-notification-service"})
    public void onDoctorCreated(DoctorCreatedEvent event) {
        LOGGER.info("Trying...");
        throw new RuntimeException("Cannot send notification");

        // LOGGER.info("Sending a notification...");
    }

    @RabbitListener(queues = {"q.fall-back-notification"})
    public void onFailedNotificationSend(DoctorCreatedEvent event) {
        LOGGER.info("Executing fallback code...");

        // LOGGER.info("Sending a notification...");
    }
}
