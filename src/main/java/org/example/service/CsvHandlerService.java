package org.example.service;

import org.example.util.CsvReaderUtil;
import org.example.model.Package;
public class CsvHandlerService {
    PackageDAO db = new PackageDAO();
    public void writeCsvFileToDB(String csvPath){
        for(Package p : CsvReaderUtil.loadCsv(csvPath)){
            db.insertPack(p);
        }
    }
}
