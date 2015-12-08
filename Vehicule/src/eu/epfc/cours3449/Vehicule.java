
package eu.epfc.cours3449;

public class Vehicule {
    private int age;
    
    public Vehicule(int age) {
        this.age=age;
    }
    
    public void start() {
        System.out.println("Véhicule "+age+" start");
    }
    
    public void stop() {
        System.out.println("Véhicule "+age+" stop");
    }
    
    public static void main(String[] args) {
        Vehicule v=new Vehicule(3);
        v.start();
        v.stop();
    }
    
}
