package calculator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;

public class ConfigLoader {
	private static JsonNode config;

	public static void loadConfig(String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Read the JSON configuration file into a tree
			config = mapper.readTree(new File(fileName));
		} catch (Exception e) {
			throw new RuntimeException("Error reading config file", e);
		}
	}

	public static String getFormatterClassName() {
		return config.get("Formatter").asText();
	}
}