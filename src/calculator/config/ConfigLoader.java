package calculator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ConfigLoader {
	private static Config config;

	public static void loadConfig(String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Read the JSON configuration file
			config = mapper.readValue(new File(fileName), Config.class);
		} catch (Exception e) {
			throw new RuntimeException("Error reading config file", e);
		}
	}

	public static String getFormatterClassName() {
		return config.getFormatter();
	}

	// Configuration class to map the JSON structure
	public static class Config {
		private String formatter = ""; //default value

		public String getFormatter() {
			return formatter;
		}

		public void setFormatter(String formatter) {
			this.formatter = formatter;
		}
	}
}