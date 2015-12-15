
/*
Vehicule est une classe mère ou une super classe
*/

package eu.epfc.cours3449;

public class Vehicule {
    int age;
    
    public void start() {
        System.out.println("Véhicule "+age+" start");
    }
    
    public void stop() {
        System.out.println("Véhicule "+age+" stop");
    }
    
    public static void main(String[] args) {
        Vehicule v=new Vehicule();
        v.age=3;
        v.start();
        v.stop();
    }
    
}
