package at.ac.tuwien.ifs.publications.restclient;

import at.ac.tuwien.ifs.publications.model.Export;
import at.ac.tuwien.ifs.publications.util.Config;
import at.ac.tuwien.ifs.publications.util.Utils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
