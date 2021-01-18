package com.letKodeit.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
	
	private static Properties pro;

    static {

        try {
            String path = "C://Users//fozbe//eclipse-workspace//com.letKodeit//config.properties";
            FileInputStream input = new FileInputStream(path);

            pro = new Properties();
            pro.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static String getProperty(String keyName){
        return pro.getProperty(keyName);
    }
    	 
    
}
