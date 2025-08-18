package org.example.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {

    private static final Logger logger = LogManager.getLogger(EnvironmentProperties.class);
    private final static Properties properties = new Properties();

    private EnvironmentProperties(){
    }

    public static Properties getProperties() {
        if (properties.isEmpty()) {
            String configFile = System.getProperty("config-file");
            if (configFile == null) {
                configFile= "firefox-qa2.properties";
            }
            logger.info("Loading configuration from file: {}", configFile);
            try (FileInputStream input = new FileInputStream("src/test/resources/" + configFile)) {
                properties.load(input);
            } catch (IOException e) {
                logger.error("Could not load configuration from file {}", configFile);
                e.printStackTrace();
            }
        }
        return properties;
    }
}
