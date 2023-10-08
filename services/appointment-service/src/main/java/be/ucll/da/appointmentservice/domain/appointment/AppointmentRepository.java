package be.ucll.da.appointmentservice.domain.appointment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    List<Appointment> getAppointmentByDoctorAndPreferredDay(Long doctor, LocalDate preferredDay);
}
