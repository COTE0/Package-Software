package org.example;

import org.example.TerminalUI.RootTreeManual;
import org.example.TerminalUI.TerminalInitializer;

public class Main {
    public static void main(String[] args) {
        TerminalInitializer tr = new TerminalInitializer();
        tr.run(new RootTreeManual().getRoot());
    }
}