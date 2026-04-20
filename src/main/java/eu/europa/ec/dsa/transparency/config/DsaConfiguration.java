package eu.europa.ec.dsa.transparency.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClient;

/**
 * Configuration class for DSA settings and properties.
 */
@Configuration
public class DsaConfiguration {

	@Value("${digital-services-act.transparency.apiKey}")
	private String apiKey;
	
	@Bean
	RestClient restClient(RestClient.Builder builder) {
	    return builder
	            .baseUrl("https://transparency.dsa.ec.europa.eu/api/v1/")
	            .requestInitializer(request -> {
                    // Set dynamic headers here
                    request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
                })
	            .build();
	}
}
