package be.ucll.da.doctorservice.domain;

public interface EventSender {

    void sendDoctorCreatedEvent(Doctor doctor);
}
