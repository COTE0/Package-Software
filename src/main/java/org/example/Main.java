package org.example;

import org.example.TerminalUI.RootTreeManual;
import org.example.TerminalUI.TerminalInitializer;
import org.example.service.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.createDB();
        TerminalInitializer tr = new TerminalInitializer();
        tr.run(new RootTreeManual().getRoot());
    }
}