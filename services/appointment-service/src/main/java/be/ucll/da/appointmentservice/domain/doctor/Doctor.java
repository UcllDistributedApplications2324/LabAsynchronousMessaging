package be.ucll.da.appointmentservice.domain.doctor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

    private String fieldOfExpertise;

    protected Doctor() {}

    public Doctor(Long id, String fieldOfExpertise) {
        this.id = id;
        this.fieldOfExpertise = fieldOfExpertise;
    }

    public Long getId() {
        return id;
    }

    public String getFieldOfExpertise() {
        return fieldOfExpertise;
    }
}
