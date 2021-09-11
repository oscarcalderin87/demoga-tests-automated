package framework.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetProperties {
    private Properties prop = new Properties();
    private static Logger LOGGER = Logger.getLogger(GetProperties.class.getName());

    public GetProperties(){
        InputStream in = getClass().getResourceAsStream("/config.properties");

        try {
            prop.load(in);
        }catch(FileNotFoundException e){
            LOGGER.log(Level.SEVERE, "The property file was not found");
        }catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can not read the property file");
        }
    }

    public String getString(String propertyName) { return prop.getProperty(propertyName); }
}
