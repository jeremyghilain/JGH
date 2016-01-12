
package eu.epfc.cours3449.Personne;

public class TestPersonne {
    public static void main(String[] args) {
        Personne[] p= new Personne[6]; 

        p[0]=new Personne('M',"Ghilain","Jeremy",30,"Belge","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        p[1]=new Personne('F',"Gaska","Gosia",30,"Polonaise","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        p[2]=new Personne('M',"Malosse","Pascal",30,"Française","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        p[3]=new Personne('M',"Ghilain","Jeremy",30,"Belge","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        //p[4]=new Employe('M', "Ghilain", "Jeremy", "JGH", "niveau 2", "B&D", "bye@sopra.com", "973");
        //p[5]=new Employe('M', "Revelaud", "Geoffrey", "GER", "niveau 2", "B&D", "bye@sopra.com", "999");
        
        for(int i=0;i<p.length;i++) {
            if(p[i] instanceof Employe) {
                Employe e=(Employe) p[i];
                System.out.println(e.employeeToString());
            }
            else System.out.println(p[i].headToString());
        }
        
        System.out.println("");
        
        for(int i=0;i<p.length;i++) {
            DisplayPerson(p[i]);
        }
        
        System.out.println("");
        
        for(int i=1;i<p.length;i++) {
            if (p[i].equals(p[0])) {
                System.out.println("La personne "+(i+1)+" est égale à la première");
            }
                
        }
        
        
        
        
        
        
        
        Employe e = new Employe('M',"Ghilain","Jeremy",30000,"Sopra","B&D","JGH","2");
        
        
    }
        
    public static void DisplayPerson(Personne pers){
        System.out.println(pers.toString());
    }
}
