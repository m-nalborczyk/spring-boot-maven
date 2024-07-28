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

//    #SPRING BOOT CONFIGURATION IS ONLY SUPPORTED BY INTELLIJ ULTIMATE
//    #IF WE DID HAVE IT WE COULD USE THIS FILE FOR CONFIG
    @Override
    public String getCurrentTime(String timeZone) {
//        TimeApiResponse response = Unirest.get(
//                timeApiConfig.getEndpoint() + timeApiConfig.getEndpoint() + "/" + timeZone)
//                .asObject(TimeApiResponse.class).getBody();
        TimeApiResponse response = Unirest.get(
                "http://worldtimeapi.org/api/timezone/Europe/" + timeZone)
                .asObject(TimeApiResponse.class).getBody();
        return response.getUtc_datetime();
    }
}
