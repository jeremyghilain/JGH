package eu.epfc.cours3449.Geometry;

import java.util.*;

public class Testcercle {
    public static void main(String[] args) {
        Cercle c1=new Cercle(5,"blanc");
        Cercle c2=new Cercle(3,"bleu");
        
        System.out.println(c1.getArea());
        
        System.out.println(Cercle.nbInstances); //On utilise la classe plutot que l'objet car c'est Static
        
    }
}
