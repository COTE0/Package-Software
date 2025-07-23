package org.example.TerminalUI;

import org.example.model.Package;
import org.example.service.CsvHandlerService;
import org.example.service.PackageDAO;
import org.example.service.PathService;
import org.example.util.CsvReaderUtil;

import java.util.List;
import java.util.Scanner;

public class RootTreeManual {

    public MenuItem getRoot(){
        MenuItem root = new MenuItem("Menu główne", null);

        MenuItem wczytajCsv = new MenuItem("Wczytaj paczki z CSV", null);
        MenuItem podajNazwe = new MenuItem("Podaj nazwę pliku CSV", () -> {
            System.out.print("Ścieżka pliku CSV: ");
            String path = new Scanner(System.in).nextLine();
            List<Package> packages = CsvReaderUtil.loadCsv(path);
            new CsvHandlerService().writePackagesToDB(packages);
            System.out.println("Wczytano " + packages.size() + " paczek.");
        });
        wczytajCsv.addChild(podajNazwe);


        MenuItem pokaz = new MenuItem("Pokaż paczki", () -> {
            PackageDAO db = new PackageDAO();
            for (Package p : db.getAllPackageCords()) {
                System.out.println(p.toString());
            }
        });


        MenuItem oblicz = new MenuItem("Oblicz trasę", () -> {
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
        });

        MenuItem exit = new MenuItem("Terminate", () -> {
            System.out.println(":P");
            System.exit(0);
        });

        root.addChild(wczytajCsv);
        root.addChild(pokaz);
        root.addChild(oblicz);
        root.addChild(exit);
        return root;
    }
}
