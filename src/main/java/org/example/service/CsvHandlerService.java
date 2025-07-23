package org.example.service;

import org.example.model.Package;

import java.util.List;

public class CsvHandlerService {
    PackageDAO db = new PackageDAO();
    public void writePackagesToDB(List<Package> packages){
        for(Package p : packages){
            db.insertPack(p);
        }
    }
}
