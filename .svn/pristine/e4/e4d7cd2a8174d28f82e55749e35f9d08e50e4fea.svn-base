package dataProviders;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
	
	private Properties configurationPropertiesFile;

	public PropertiesHandler(String propertyPathAndFileName) {
		this.configurationPropertiesFile = this.setProperties(propertyPathAndFileName);
	}
	
	public PropertiesHandler(InputStream defaultProperties) {
		this.configurationPropertiesFile = this.loadProperties(defaultProperties);
	}

	private Properties setProperties(String propertyPathAndFileName) {
		// TODO Auto-generated method stub
		return this.loadProperties(getFileContentAsStream(propertyPathAndFileName));
	}

	private Properties loadProperties(InputStream Input) {
		Properties defaultProps = new Properties();
		
		try
		{
			defaultProps.load(Input);
			return defaultProps;
		} catch (Exception e) {
		throw new RuntimeException("faled to load the properties.", e);
	}
	}
	
	public static InputStream getFileContentAsStream(String resource) {
		return ClassLoader.getSystemResourceAsStream(resource);
	}
	
	public Properties getProperties() {
		return this.configurationPropertiesFile;
	}

}
