package org.example.util;

import org.example.model.Cord;
import org.example.model.Package;
public class DistUtil {

    //distanceSquared
    public static float quadraticPathOfPackage(Package p, Cord cord){
        return (float) (Math.pow(p.getDestX()- cord.getX(), 2)+ Math.pow(p.getDestY()- cord.getY(), 2));
    }
}
