package eu.epfc.cours3449;

import java.util.*;

public class Cercle {
    static int nbInstances=0; // cela permet de faire appel à cette variable partout et en transversal
    double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
        nbInstances++;
    }
    
    public double getArea() {
        return Math.PI *rayon*rayon;
    }
}
