
package eu.epfc.cours3449.Personne;

public class TestPersonne {
    public static void main(String[] args) {
        Personne[] p= new Personne[4]; 
        // double age, String nationalite, String adresse, String mailadresse, String telephone
        p[0]=new Personne('M',"Ghilain","Jeremy",30,"Belge","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        p[1]=new Personne('F',"Gaska","Gosia",30,"Polonaise","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        p[2]=new Personne('M',"Malosse","Pascal",30,"Française","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        p[3]=new Personne('M',"Ghilain","Jeremy",30,"Belge","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500");
        
        System.out.println(p[0].toString());
        System.out.println(p[1].toString());
        System.out.println(p[2].toString());
        System.out.println(p[3].toString());
        
        for(int i=0;i<p.length;i++) {
            if (p[i].equals('M',"Ghilain","Jeremy",30,"Belge","Rue Colonel Bourg 110, Schaerbeek, Belgique","hello@gmail.com","0472424500")) {
                System.out.println("La personne "+i+" est égale");
            }
                
        }
        
    }
}
