package at.ac.tuwien.ifs.semweb.publications.restclient;

import at.ac.tuwien.ifs.semweb.publications.model.Export;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Extracts data from the TU publications API.
 */
@Service
public class PublikExtractor {
	@Autowired
	private RestTemplate restTemplate;

	public void start() {
		Export export = restTemplate.getForObject(PublikConstants.buildUriSinceLastDate(2016,1,1,1030), Export.class);
		System.out.println(export);
	}
}
