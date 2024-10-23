package calculator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ConfigLoader {
	private static String fileName;

	public static void setFileName(String aFileName) {
		fileName = aFileName;
	}

	public static String loadFormatterClassName() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Read the JSON configuration file
			Config config = mapper.readValue(new File(fileName), Config.class);
			return config.getFormatter();
		} catch (Exception e) {
			throw new RuntimeException("Error reading config file", e);
		}
	}

	// Configuration class to map the JSON structure
	public static class Config {
		private String formatter;

		public String getFormatter() {
			return formatter;
		}

		public void setFormatter(String formatter) {
			this.formatter = formatter;
		}
	}
}