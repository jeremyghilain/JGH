package eu.epfc.cours3449;

import java.util.*;

public class Randomtest {

    public static void main(String[] args) {
        System.out.println("Hello Git, this is a test");
        int nbrows=2, nblines=10, seed=100;
        
        for (int i=0;i<nbrows;i++) {
            generaterandomint(nblines, seed);
            System.out.println("");
        }
    }

    private static void generaterandomint(int n, int seed) {
        Random r2= new Random();
        for (int j=0;j<n;j++) {
            System.out.print(r2.nextInt(seed)+" ");
        }
    }
    
}
