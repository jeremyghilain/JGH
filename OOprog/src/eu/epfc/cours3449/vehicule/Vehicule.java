
/*
Vehicule est une classe mère ou une super classe
*/

package eu.epfc.cours3449.vehicule;

public class Vehicule {
    private int age;
    
    public void Vehicule(int age){
        this.age=age;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        if(age>=0 && age<=5000){
            this.age=age;
        }
    }
    
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
