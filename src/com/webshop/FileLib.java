package com.webshop;

import java.io.FileInputStream;
import java.util.Properties;

public class FileLib implements IAutoConsts{
	
	public String getPropValue(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream(PROP_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		String propValue = prop.getProperty(Key, "Incorrect Key");
		return propValue;
	}

}
