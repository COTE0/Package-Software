package org.example.TerminalUI;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private final String name;
    private final Runnable action;
    private final List<MenuItem> children;

    public MenuItem(String name, Runnable action) {
        this.name = name;
        this.action = action;
        this.children = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void addChild(MenuItem child){
        children.add(child);
    }
    public List<MenuItem> getChildren(){
        return children;
    }
    public void execute(){
        if(action!=null){
            action.run();
        }
    }
}
