package managers;

import configuration.Configuration;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static Configuration configuration;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public Configuration getConfiguration() {
//	 	if (configuration == null)
//		{
//			return  new Configuration();
//		}
//	 	else
//		{
//			return configuration;
//		}
		return (configuration == null) ? new Configuration() : configuration;
	}


}

