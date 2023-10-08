package be.ucll.da.doctorservice.messaging;

import be.ucll.da.doctorservice.api.model.ApiDoctor;
import be.ucll.da.doctorservice.api.model.DoctorCreatedEvent;
import be.ucll.da.doctorservice.domain.Doctor;
import be.ucll.da.doctorservice.domain.EventSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventSender implements EventSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqEventSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendDoctorCreatedEvent(Doctor doctor) {
        this.rabbitTemplate.convertAndSend("x.doctor-created", "", toEvent(doctor));
    }

    private DoctorCreatedEvent toEvent(Doctor doctor) {
        return new DoctorCreatedEvent()
                .doctor(new ApiDoctor()
                        .id(doctor.getId())
                        .age(doctor.getAge())
                        .address(doctor.getAddress())
                        .lastName(doctor.getLastName())
                        .firstName(doctor.getFirstName())
                        .fieldOfExpertise(doctor.getFieldOfExpertise()));
    }
}
