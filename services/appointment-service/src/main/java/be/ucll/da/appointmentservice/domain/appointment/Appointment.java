package be.ucll.da.appointmentservice.domain.appointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;

    private String neededExpertise;

    private String patientFirstName;

    private String patientLastName;

    private LocalDate preferredDay;

    private Long doctor;

    protected Appointment() {}

    public Appointment(String neededExpertise, String patientFirstName, String patientLastName, LocalDate preferredDay, Long doctor) {
        this.neededExpertise = neededExpertise;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.preferredDay = preferredDay;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public String getNeededExpertise() {
        return neededExpertise;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public LocalDate getPreferredDay() {
        return preferredDay;
    }

    public Long getDoctor() {
        return doctor;
    }
}
