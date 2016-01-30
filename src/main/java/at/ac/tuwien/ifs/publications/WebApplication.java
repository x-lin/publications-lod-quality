package at.ac.tuwien.ifs.publications;

import at.ac.tuwien.ifs.publications.restclient.PublikExtractor;
import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Spring boot application main class.
 *
 * @author xlin
 */
@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		for(HttpMessageConverter converter : restTemplate.getMessageConverters()) {
			if(converter instanceof Jaxb2RootElementHttpMessageConverter) {
				((Jaxb2RootElementHttpMessageConverter)converter).setSupportDtd(true);
				break;
			}
		}

		return restTemplate;
	}

	@Bean
	public PublikExtractor publikExtractor() {
		return new PublikExtractor();
	}
}
