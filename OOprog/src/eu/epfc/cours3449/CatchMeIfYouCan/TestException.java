
package eu.epfc.cours3449.CatchMeIfYouCan;

import java.util.Scanner;


public class TestException {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        int n1=0,n2=0;
        
        while(true){
            try {
                n1=input.nextInt();
                n2=input.nextInt();
                System.out.println("The result is "+(n1+n2));
                break; //will throw if and when the result is given
            } catch (Exception e) {
                input.nextLine();
                System.out.println(e);
                System.out.println("Error, please enter a correct number");
            } finally {
                /* for cleaning of code/variables, but not really useful in java 
                "Dispose" method can be used*/
            }
        }
        
        
        
    }
}
