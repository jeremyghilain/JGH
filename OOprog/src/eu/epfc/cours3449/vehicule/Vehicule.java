
/*
Vehicule est une classe mère ou une super classe
*/

package eu.epfc.cours3449.vehicule;

public class Vehicule {
    private double age; // en jours
    
    public void Vehicule(int age){
        this.age=age;
    }
    
    public double getAge(){
        return age/365;
    }
    
    public double getAge(int unit){
        switch (unit){
            case 0: return age; // en jours
            case 1: getAge(); // en années
            default: System.out.println("Valeur de code hors limite "+unit);
        }
        return age;
    }
    
    public void setAge(int age){
        if(age>=0 && age<=5000){
            this.age=age*365;
        }
    }

    public void setAge(int age, int unit){
        switch (unit){
            case 0: // en jours
                if(age>=0 && age<=5000*365){this.age=age;}
                break;
            case 1: setAge(age); break; // en années
            default: System.out.println("Valeur de code hors limite "+unit);
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
