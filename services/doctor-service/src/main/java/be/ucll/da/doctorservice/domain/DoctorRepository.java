package be.ucll.da.doctorservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    List<Doctor> findAllByFieldOfExpertise(String fieldOfExpertise);

}
