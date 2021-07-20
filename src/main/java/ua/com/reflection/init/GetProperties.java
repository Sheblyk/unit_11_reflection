package ua.com.reflection.init;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

    public Properties loadFromFile() {
        Properties properties = new Properties();
        try (InputStream prop = new FileInputStream("src/main/resources/app.properties")) {
            properties.load(prop);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
