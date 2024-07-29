package spring.course.services;

import kong.unirest.Unirest;
import org.springframework.stereotype.Service;
import spring.course.config.TimeApiConfig;
import spring.course.model.TimeApiResponse;

@Service
public class TimeServiceImplementation implements TimeService{

    private final TimeApiConfig timeApiConfig;

    public TimeServiceImplementation(TimeApiConfig timeApiConfig) {
        this.timeApiConfig = timeApiConfig;
    }

    @Override
    public String getCurrentTime(String timeZone) {
        TimeApiResponse response = Unirest.get(
                timeApiConfig.getEndpoint() + timeApiConfig.getContinent() + "/" + timeZone)
                .asObject(TimeApiResponse.class).getBody();

        return response.getUtc_datetime();
    }
}
