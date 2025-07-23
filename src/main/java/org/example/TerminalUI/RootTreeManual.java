package org.example.TerminalUI;

import org.example.model.Client;
import org.example.model.Package;
import org.example.service.CsvHandlerService;
import org.example.service.PackageDAO;
import org.example.service.PathService;
import org.example.util.CsvReaderUtil;

import java.util.List;
import java.util.Scanner;

public class RootTreeManual {

    public MenuItem getRoot(){
        MenuItem root = new MenuItem("Main menu", null);

        MenuItem importCSVPckg = new MenuItem("Import Packages from a CSV File", ()->{
            System.out.print("Path to your CSV File(Absolute or in your .jar dir): ");
            String path = new Scanner(System.in).nextLine();
            List<Package> packages = CsvReaderUtil.loadCsvPckg(path);
            CsvHandlerService.writePackagesToDB(packages);
            System.out.println(packages.size() + " Packages Loaded.");
        });
        MenuItem importCSVClient = new MenuItem("Import Clients from a CSV File", ()->{
            System.out.print("Path to your CSV File(Absolute or in your .jar dir): ");
            String path = new Scanner(System.in).nextLine();
            List<Client> clients = CsvReaderUtil.loadCsvCl(path);
            CsvHandlerService.writeClientsToDB(clients);
            System.out.println(clients.size() + " Clients Loaded.");
        });

        MenuItem showAllPackages = new MenuItem("Show All Packages", () -> {
            for (Package p : PackageDAO.getAllPackages()) {
                System.out.println(p.toString());
            }
        });
        MenuItem showAllClients = new MenuItem("Show All Clienst", () -> {
            for (Client cl : PackageDAO.getAllClients()) {
                System.out.println(cl.toString());
            }
        });


        MenuItem oblicz = new MenuItem("Calculate Route", () -> {
            Scanner in = new Scanner(System.in);
            System.out.print("X: ");
            float x = Float.parseFloat(in.nextLine());
            System.out.print("Y: ");
            float y = Float.parseFloat(in.nextLine());
            List<Package> route = new PathService().getNearestNeighbourPath(x, y);
            System.out.println("Route:");
            for (Package p : route){
                System.out.println(p.toString());
                for (int i=0;i<p.toString().length();i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            in.close();
        });

        MenuItem exit = new MenuItem("Terminate", () -> {
            System.out.println(":P");
            System.exit(0);
        });
        MenuItem resetTable = new MenuItem("Reset Table", () -> {
            Scanner in = new Scanner(System.in);
            System.out.print("Delete records from: ");
            String table = in.nextLine();
            PackageDAO.resetTable(table);
        });
        root.addChild(showAllClients);
        root.addChild(showAllPackages);
        root.addChild(importCSVClient);
        root.addChild(importCSVPckg);
        root.addChild(oblicz);
        root.addChild(resetTable);
        root.addChild(exit);
        return root;
    }
}
