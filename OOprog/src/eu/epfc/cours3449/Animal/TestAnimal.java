
package eu.epfc.cours3449.Animal;

import eu.epfc.cours3449.Personne.Employe;
import eu.epfc.cours3449.Personne.Personne;

public class TestAnimal {
    public static void main(String[] args) {
        Animal[] as= new Animal[3]; 
        as[0]=new Animal(2);
        as[1]=new Vertebre(3,6);
        as[2]=new Animal(5);
        
        for (int i=0;i<as.length;i++) {
            System.out.println(as[i].toString());
            if(as[i] instanceof Vertebre) {
                Animal a=(Animal) as[i];
                a.grandit();
                as[i]=a;
                System.out.println(as[i].toString());
                
                Vertebre v=(Vertebre)as[i];
                v.grandit(4);
                System.out.println(v.toString());
            } else {
                as[i].grandit();
                System.out.println(as[i].toString());
            }
        }
    }
}
