package be.ucll.da.doctorservice.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String fieldOfExpertise;

    private String address;

    protected Doctor() {}

    public Doctor(String firstName, String lastName, Integer age, String fieldOfExpertise, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.fieldOfExpertise = fieldOfExpertise;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getFieldOfExpertise() {
        return fieldOfExpertise;
    }

    public String getAddress() {
        return address;
    }
}
