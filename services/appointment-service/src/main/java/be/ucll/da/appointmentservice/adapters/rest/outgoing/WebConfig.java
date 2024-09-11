package be.ucll.da.appointmentservice.adapters.rest.outgoing;

import be.ucll.da.appointmentservice.client.doctor.api.DoctorApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public DoctorApi doctorApi() {
        return new DoctorApi();
    }
}
