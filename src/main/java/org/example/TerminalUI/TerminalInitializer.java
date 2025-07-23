package org.example.TerminalUI;

import java.util.List;
import java.util.Scanner;

public class TerminalInitializer {
    private final Scanner scanner = new Scanner(System.in);
    public void run(MenuItem root){
        MenuItem current = root;
        while (true){
            List<MenuItem> options =current.getChildren();
            if(options.isEmpty()){
                current.execute();
                current=root;
                continue;
            }
            System.out.println("\n--"+current.getName()+"--");
            for(int i=0;i< options.size();i++){
                System.out.println((i+1)+". "+options.get(i).getName());
            }
            System.out.println("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice<1||choice> options.size()){
                System.out.println("Incorrect choice.");
                continue;
            }
            current=options.get(choice-1);
        }
    }
}
