package org.example.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.model.Client;
import org.example.model.Package;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderUtil {
    //All ID fields are created automatically so do not write them in the csv

    //Make sure csv format is: client_id,destX,destY,time_origin
    public static List<Package> loadCsvPckg(String filePath){
        try(FileReader fr = new FileReader(filePath);
            CSVReader csvReader = new CSVReaderBuilder(fr).withSkipLines(1).build()) {
            String[] nextRecord;
            List<Package> packages=new ArrayList<>();
            while ((nextRecord = csvReader.readNext()) != null) {
                Package pckg = new Package();
                pckg.setClient_id(Integer.parseInt(nextRecord[0]));
                pckg.setDestX(Float.parseFloat(nextRecord[1]));
                pckg.setDestY(Float.parseFloat(nextRecord[2]));
                pckg.setTime_origin(LocalDate.parse(nextRecord[3]));
                packages.add(pckg);
            }
            return packages;
        } catch (IOException e) {
            System.err.println("Bad csv type!!!!!");
            throw new RuntimeException(e);
        }
    }
    //Make sure csv format is: first_name, last_name
    public static List<Client> loadCsvCl(String filePath){
        try(FileReader fr = new FileReader(filePath);
            CSVReader csvReader = new CSVReaderBuilder(fr).withSkipLines(1).build()) {
            String[] nextRecord;
            List<Client> clients=new ArrayList<>();
            while ((nextRecord = csvReader.readNext()) != null) {
                Client cl = new Client();
                cl.setFirst_name(nextRecord[0]);
                cl.setLast_name(nextRecord[1]);
                clients.add(cl);
            }
            return clients;
        } catch (IOException e) {
            System.err.println("Bad csv type!!!!!");
            throw new RuntimeException(e);
        }
    }
}
