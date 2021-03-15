package com.webshop.generic;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Satyanka Arava
 *
 */
public class FileLib implements IAutoConsts{
	
	/**
	 * This generic reusable method is used to get property Values from config.Properties file
	 * @param Key
	 * @return propValue
	 * @throws Throwable
	 */
	public String getPropValue(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream(PROP_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(Key, "Incorrect Key");
		return propValue;
	}

}
