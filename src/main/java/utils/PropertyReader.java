package utils;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

    static Properties properties;

    public PropertyReader(){
        loadAllProperties();
    }

    public void loadAllProperties(){
        BufferedReader reader;
        String propertyFilePath = "src//main//resources//config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static String readItem(String propertyName){
        return properties.getProperty(propertyName);
    }
}
