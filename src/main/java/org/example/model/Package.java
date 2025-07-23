package org.example.model;

import java.time.LocalDate;

public class Package {
    private int P_ID;
    private float destX;
    private float destY;
    private int client_id;
    private LocalDate time_origin;

    public LocalDate getTime_origin() {
        return time_origin;
    }
    public String toString(){
        return "P_ID: "+getP_ID()+"  client_id: "+getClient_id()+"  destX: "+getDestX()+
                "  destY: "+getDestY()+ "  time_origin: "+getTime_origin().toString();
    }
    public void setTime_origin(LocalDate time_origin) {
        this.time_origin = time_origin;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public float getDestX() {
        return destX;
    }

    public void setDestX(float destX) {
        this.destX = destX;
    }

    public float getDestY() {
        return destY;
    }

    public void setDestY(float destY) {
        this.destY = destY;
    }
}
