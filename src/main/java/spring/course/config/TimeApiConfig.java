package spring.course.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


//#SPRING BOOT CONFIGURATION IS ONLY SUPPORTED BY INTELLIJ ULTIMATE
//#IF WE DID HAVE IT WE COULD USE THIS FILE FOR CONFIG

@Configuration
@ConfigurationProperties(prefix = "api")
public class TimeApiConfig {

    private String endpoint;
    private String continent;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
