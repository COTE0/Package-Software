package org.example.util;

import com.opencsv.CSVReader;
import org.example.model.Package;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class CsvReaderUtil {
    //Make sure csv format is: client_id,destX,destY,time_origin
    public static List<Package> loadCsv(String filePath){
        try(FileReader fr = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fr)) {
            List<Package> packages=new ArrayList<>();
            String[] nextRecord= csvReader.readNext();
            if(Objects.equals(nextRecord[0], "client_id") && Objects.equals(nextRecord[1], "destX") && Objects.equals(nextRecord[2], "destY")
                    && Objects.equals(nextRecord[3], "time_origin")){
                while ((nextRecord = csvReader.readNext()) != null) {
                    Package pckg = new Package();
                    pckg.setClient_id(Integer.parseInt(nextRecord[0]));
                    pckg.setDestX(Float.parseFloat(nextRecord[1]));
                    pckg.setDestY(Float.parseFloat(nextRecord[2]));
                    pckg.setTime_origin(LocalDate.parse(nextRecord[3]));
                    packages.add(pckg);
                }
            }else {
                System.out.println("Bad csv type!!!!!");
            }
            return packages;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
