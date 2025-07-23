package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    public static String getAppConfig(String property) throws IOException {
        String appConfigPath = FileUtil.resourcesPath + "app.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        return appProps.getProperty(property);
    }
}
