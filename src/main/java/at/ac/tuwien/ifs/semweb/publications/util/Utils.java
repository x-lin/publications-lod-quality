package at.ac.tuwien.ifs.semweb.publications.util;

/**
 * Convenience methods.
 *
 * @author xlin
 */
public class Utils {
	/**
	 * Returns a new value, if one exists, if not, return the default value.
	 *
	 * @param defaultValue default value
	 * @param newValue custom value
	 * @return the assigned value
	 */
	public static String assignIfExists(String defaultValue, String newValue) {
		return newValue != null ? newValue : defaultValue;
	}

	/**
	 * Converts a bool to an int value.
	 *
	 * @param bool
	 * @return an int, where 0 equals false and 1 equals true
	 */
	public static int boolToInt(boolean bool) {
		return bool ? 1 : 0;
	}

	public static String appendZeroIfSmallerTen(int number) {
		String numberString = number+"";
		if (numberString.length() < 1) {
			numberString = "0" + numberString;
		}

		return numberString;
	}
}
