package org.example.model;

public class Client {
    private int client_id;
    private String first_name;
    private String last_name;
    public String toString(){
        return "client_id: "+getClient_id()+"  first_name: "+getFirst_name()+"  last_name: "+getLast_name();
    }
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
