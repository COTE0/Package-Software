package org.example.service;

import org.example.model.Cord;
import org.example.model.Package;
import org.example.util.DistUtil;

import java.util.List;

public class PathService {
    public List<Package> getNearestNeighbourPath(float originX, float originY){
        List<Package> packages=new PackageDAO().getAllPackageCords();
        Cord origin=new Cord(originX, originY);
        for(int visitedCount=0;visitedCount< packages.size()-1;visitedCount++){
            int minIndex=visitedCount;
            float min= DistUtil.quadraticPathOfPackage(packages.get(minIndex), origin);
            for(int i=visitedCount+1;i< packages.size();i++){
                float dist=DistUtil.quadraticPathOfPackage(packages.get(i), origin);
                if (dist<min){
                    min=dist;
                    minIndex=i;
                }
            }
            Package pNearest = packages.get(minIndex);
            origin.setX(pNearest.getDestX());
            origin.setY(pNearest.getDestY());
            Package tempPckg= packages.get(visitedCount);
            packages.set(visitedCount, packages.get(minIndex));
            packages.set(minIndex, tempPckg);
        }
        return packages;
    }
}
