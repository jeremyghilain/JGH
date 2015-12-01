package eu.epfc.cours3449;

import java.util.*;

public class project1 {

    public static void main(String[] args) {
        System.out.println("Hello Git, this is a test");
        
        generaterandomint(10, 1000);
        System.out.println("");
        
        generaterandomint(10, 1000);
    }

    private static void generaterandomint(int n, int seed) {
        Random r2= new Random();
        for (int j=0;j<n;j++) {
            System.out.println(r2.nextInt(seed));
        }
    }
    
}
