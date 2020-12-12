package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	public String ReadProperties(String FilePath, String keyToRead) throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(FilePath);
		prop.load(fs);
		return prop.getProperty(keyToRead);
	}
}
