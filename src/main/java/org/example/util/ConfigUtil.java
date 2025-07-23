package org.example.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ConfigUtil {
    public static String getAppConfig(String property) throws IOException {
        Properties appProps = new Properties();
        try(InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (in == null) {
                throw new FileNotFoundException("app.properties not found in resources");
            }
            appProps.load(in);
        }
        return appProps.getProperty(property);
    }
}
