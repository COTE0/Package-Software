package org.example.util;

import java.io.*;
import java.util.stream.Collectors;

public class SqlUtil {
    public static String[] getStringQueries(String fileName){
        try(InputStream in = SqlUtil.class.getClassLoader().getResourceAsStream("sql/"+fileName)) {
            assert in != null;
            try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                String sql = br.lines().collect(Collectors.joining("\n"));
                String[] quaries=sql.split(";");
                for(int i=0;i< quaries.length;i++){
                    quaries[i]=quaries[i].trim();
                }
                return quaries;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getStringQuary(String fileName){
        return getStringQueries(fileName)[0];
    }
}
