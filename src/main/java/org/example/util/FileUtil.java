package org.example.util;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class FileUtil {
    public static String resourcesPath;
    public static String sqlFilesPath;
    private static URL rawResoucesPath=FileUtil.class.getClassLoader().getResource("");
    static {
        try {
            resourcesPath = Paths.get(rawResoucesPath.toURI()) +"\\";
            sqlFilesPath = resourcesPath +"sql\\";
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
