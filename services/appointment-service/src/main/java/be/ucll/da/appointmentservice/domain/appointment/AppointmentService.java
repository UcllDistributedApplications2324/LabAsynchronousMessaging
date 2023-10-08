package be.ucll.da.appointmentservice.domain.appointment;

import be.ucll.da.appointmentservice.api.model.ApiAppointment;
import be.ucll.da.appointmentservice.domain.doctor.Doctor;
import be.ucll.da.appointmentservice.domain.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public void createAppointment(ApiAppointment data) {
        List<Doctor> doctors = doctorRepository.findAllByFieldOfExpertise(data.getNeededExpertise());

        Doctor selectedDoctor = null;
        for (Doctor doctor : doctors) {
            List<Appointment> appointments = appointmentRepository.getAppointmentByDoctorAndPreferredDay(doctor.getId(), data.getPreferredDay());

            if (appointments.isEmpty()) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            throw new AppointmentException("No doctor available for day and expertise");
        }

        Appointment appointment = new Appointment(
                data.getNeededExpertise(),
                data.getPatientFirstName(),
                data.getPatientLastName(),
                data.getPreferredDay(),
                selectedDoctor.getId());

        appointmentRepository.save(appointment);
    }
}
