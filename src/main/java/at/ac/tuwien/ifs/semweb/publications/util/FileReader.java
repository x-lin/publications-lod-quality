package at.ac.tuwien.ifs.semweb.publications.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Util methods to read data from files.
 *
 *  @author xlin
 */
public class FileReader {
	public static Properties readPropertiesFile(String resourcePath) {
		Properties properties = null;

		try (InputStream in = FileReader.class.getResourceAsStream(resourcePath)) {
			properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}
}
