package at.ac.tuwien.ifs.semweb.publications.util;

import java.util.Properties;

/**
 * Defines configuration properties. These are the properties that stored in the config.properties file.
 *
 *  @author xlin
 */
public class Config {
	/**
	 * Path to the configuration file.
	 */
	public static final String PROPERTIES_PATH = "/config.properties";

	/**
	 * URL of the Sesame DB.
	 */
	public static final String SESAME_DB_URL;

	/**
	 * Path to the ontology file.
	 */
	public static final String ONT_FILE;

	/**
	 * Ontology context for Sesame DB.
	 */
	public static final String ONT_CONTEXT;

	/**
	 * Data context for Sesame DB.
	 */
	public static final String DATA_CONTEXT;

	/**
	 * Base URL for the TU Wien publications DB.
	 */
	public static final String PUBLIK_URL;

	/**
	 * Default value for the ontology context. Will be used, if no context info is present.
	 */
	private static final String DEFAULT_ONT_CONTEXT = "OntologyContext";

	/**
	 * Default value for the data context. Will be used, if no context info is present.
	 */
	private static final String DEFAULT_DATA_CONTEXT = "DataContext";

	static {
		Properties properties = FileReader.readPropertiesFile(PROPERTIES_PATH);

		SESAME_DB_URL = properties.getProperty("sesame-url");
		ONT_FILE = properties.getProperty("ontology-path");
		ONT_CONTEXT = Utils.assignIfExists(DEFAULT_ONT_CONTEXT, properties.getProperty("ontology-context"));
		DATA_CONTEXT = Utils.assignIfExists(DEFAULT_DATA_CONTEXT, properties.getProperty("data-context"));
		PUBLIK_URL = properties.getProperty("publik-base-url");
	}
}
