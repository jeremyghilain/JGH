package eu.epfc.cours3449.Geometry;

import eu.epfc.cours3449.Geometry.GeometricObject;
import java.util.*;

public class Cercle extends GeometricObject{
    static int nbInstances=0; // cela permet de faire appel à cette variable partout et en transversal
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
        nbInstances++;
    }

    public static int getNbInstances() {
        return nbInstances;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
    
    public double getArea() {
        return Math.PI *rayon*rayon;
    }
}
