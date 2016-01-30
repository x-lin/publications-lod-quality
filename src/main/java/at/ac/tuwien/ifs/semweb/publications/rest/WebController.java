package at.ac.tuwien.ifs.semweb.publications.rest;

import at.ac.tuwien.ifs.semweb.publications.restclient.PublikExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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