package calculator.factory;

import java.lang.reflect.Constructor;

public class GenericFactory {
	// Method to create an instance from a string class name
	protected Object createFromClassName(String className) {
		try {
			// Load the class based on the string class name
			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Failed to create an instance of " + className, e);
		}
	}
}
