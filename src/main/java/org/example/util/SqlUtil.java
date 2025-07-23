package org.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SqlUtil {
    public static String[] getStringQuaries(String fileName){
        try {
            String sql = Files.readString(Paths.get(FileUtil.sqlFilesPath + fileName));
            String[] quaries=sql.split(";");
            for(int i=0;i< quaries.length;i++){
                quaries[i]=quaries[i].trim();
            }
            return quaries;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getStringQuary(String fileName){
        return getStringQuaries(fileName)[0];
    }
}
