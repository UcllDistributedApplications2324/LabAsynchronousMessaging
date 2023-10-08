package be.ucll.da.doctorservice.web;

import be.ucll.da.doctorservice.api.DoctorApiDelegate;
import be.ucll.da.doctorservice.api.model.ApiDoctor;
import be.ucll.da.doctorservice.api.model.ApiDoctors;
import be.ucll.da.doctorservice.domain.Doctor;
import be.ucll.da.doctorservice.domain.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DoctorController implements DoctorApiDelegate {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public ResponseEntity<ApiDoctors> getDoctors(String fieldOfExpertise) {
        ApiDoctors doctors = new ApiDoctors();
        doctors.addAll(
            doctorService.getDoctors(fieldOfExpertise).stream()
                .map(this::toDto)
                .toList()
        );

        return ResponseEntity.ok(doctors);
    }

    @Override
    public ResponseEntity<Void> createDoctor(ApiDoctor doctor) {
        doctorService.createDoctor(doctor);
        return ResponseEntity.ok().build();
    }

    private ApiDoctor toDto(Doctor doctor) {
        return new ApiDoctor()
                .id(doctor.getId())
                .age(doctor.getAge())
                .address(doctor.getAddress())
                .lastName(doctor.getLastName())
                .firstName(doctor.getFirstName())
                .fieldOfExpertise(doctor.getFieldOfExpertise());
    }
}
