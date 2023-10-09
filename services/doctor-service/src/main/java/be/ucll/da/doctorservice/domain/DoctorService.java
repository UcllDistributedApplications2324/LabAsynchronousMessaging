package be.ucll.da.doctorservice.domain;

import be.ucll.da.doctorservice.api.model.ApiDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorService {

    private final DoctorRepository repository;

    @Autowired
    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public void createDoctor(ApiDoctor data) {
        Doctor doctor = new Doctor(
             data.getFirstName(),
             data.getLastName(),
             data.getAge(),
             data.getFieldOfExpertise(),
             data.getAddress()
        );

        repository.save(doctor);
    }

    public List<Doctor> getDoctors(String fieldOfExpertise) {
        if (fieldOfExpertise == null || fieldOfExpertise.isEmpty()) {
            throw new NoFieldOfExpertiseException("FieldOfExpertise is empty");
        }

        return repository.findAllByFieldOfExpertise(fieldOfExpertise);
    }
}
