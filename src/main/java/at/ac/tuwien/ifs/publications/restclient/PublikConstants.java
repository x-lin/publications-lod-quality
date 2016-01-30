package at.ac.tuwien.ifs.publications.restclient;

import at.ac.tuwien.ifs.publications.util.Config;
import at.ac.tuwien.ifs.publications.util.Utils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Defines constants used by the TU publications API. For a comprehensive list of API parameters, check out
 * http://publik.tuwien.ac.at/info/manual/Publikationsdatenbank2.pdf
 *
 * @author xlin
 */
public class PublikConstants {
	public static final String INSTITUTE_PARAM = "inst";

	public static final String INSTITUTE_VALUES;

	/**
	 * Fetch publications starting from a year. Note that this filter ONLY works in combination with setting the zeit
	 * parameter to 1, otherwise the return will still be all publications.
	 */
	public static final String FROM_PARAM = "from";

	/**
	 * Fetch publications up to a year. Note that this filter ONLY works in combination with setting the zeit
	 * parameter to 1, otherwise the return will still be all publications.
	 */
	public static final String TO_PARAM = "to";

	/**
	 * Parameter setting, whether the from/to are factored in into the search or not. Can be 0 or 1.
	 */
	public static final String ZEIT_PARAM = "zeit";

	/**
	 * Fetches all publications starting from a certain time. The value has two possible values:
	 * 1.) JJJJ-MM-TT
	 * 2.) JJJ-MM-TT%20HH:MM:SS
	 *
	 * Note that this parameter, unlike "from" and "to", does NOT need "zeit" to work.
	 */
	public static final String LASTMOD_PARAM = "lastmod";

	//TODO replace with date format input
	public static URI buildUriSinceLastDate(int year, int month, int day, int instituteValue) {
		String monthString = Utils.appendZeroIfSmallerTen(month);
		String dayString = Utils.appendZeroIfSmallerTen(day);
		String date = year + "-" + monthString + "-" + dayString;

		URI uri = UriComponentsBuilder
				.fromHttpUrl(Config.PUBLIK_URL)
				.queryParam(PublikConstants.LASTMOD_PARAM, date)
				.queryParam(PublikConstants.INSTITUTE_PARAM, instituteValue)
				.build().encode().toUri();

		return uri;
	}

	public static URI buildUri(int instituteValue){
		return UriComponentsBuilder
				.fromHttpUrl(Config.PUBLIK_URL)
				.queryParam(PublikConstants.INSTITUTE_PARAM, instituteValue)
				.build().encode().toUri();
	}

	public static URI buildUriFromToYear(int fromYear, int toYear, int instituteValue) {
		URI uri = UriComponentsBuilder
				.fromHttpUrl(Config.PUBLIK_URL)
				.queryParam(PublikConstants.INSTITUTE_PARAM, instituteValue)
				.queryParam(PublikConstants.FROM_PARAM, fromYear)
				.queryParam(PublikConstants.TO_PARAM, toYear)
				.queryParam(PublikConstants.ZEIT_PARAM, Utils.boolToInt(true))
				.build().encode().toUri();

		return uri;
	}

	static {
		INSTITUTE_VALUES = null;
	}
}
