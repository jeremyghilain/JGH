package eu.epfc.cours3449;

import java.util.*;

public class Cercle {
    static int nbInstances=0; // cela permet de faire appel à cette variable partout et en transversal
    static double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
        nbInstances++;
    }

    public static int getNbInstances() {
        return nbInstances;
    }

    public static double getRayon() {
        return rayon;
    }

    public static void setRayon(double rayon) {
        Cercle.rayon = rayon;
    }
    
    public double getArea() {
        return Math.PI *rayon*rayon;
    }
}
