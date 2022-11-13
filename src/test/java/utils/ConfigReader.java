package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
   public Properties property;
    private String propertyFilePath="src/test/resources/Config/Configuration.properties";
	public ConfigReader()
	{ 
	  try
	    {
		FileInputStream fi=new FileInputStream(propertyFilePath);
		property= new Properties();
		try {
		property.load(fi);
		fi.close();
		}
		catch (IOException e) {
            throw new RuntimeException(e);
        }
	  } catch (FileNotFoundException e) {
        throw new RuntimeException("Configuration file not found at "+propertyFilePath);
	      }
	}
}
	
