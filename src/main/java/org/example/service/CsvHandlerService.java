package org.example.service;

import org.example.model.Client;
import org.example.model.Package;

import java.util.List;

public class CsvHandlerService {

    public static void writePackagesToDB(List<Package> packages){
        for(Package p : packages){
            PackageDAO.insertPack(p);
        }
    }
    public static void writeClientsToDB(List<Client> clients){
        for(Client c : clients){
            PackageDAO.insertClient(c);
        }
    }
}
