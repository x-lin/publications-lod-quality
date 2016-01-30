package at.ac.tuwien.ifs.publications.rest;

import at.ac.tuwien.ifs.publications.restclient.PublikExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class WebController {
	@Autowired
	PublikExtractor extractor;

	@RequestMapping(value = "", method= RequestMethod.GET)
	public int get() {
		extractor.start();

		return 1000;
	}
}