import java.util.Scanner;

import java.util.Scanner;

public class CountdownTimer {
    private static boolean answered = false;
    
    public static void countDown(int start){

        Scanner s = new Scanner(System.in);

        Thread cD = new Thread(() ->{
        for (int i = start; i >= 0; i--){
            
            if (answered){
                return;
            }
            System.out.print("\r Tid kvar: " + i + " Ditt svar:");
            
            try {
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                System.out.println("");
            }
            
        }
        if(!answered){
        System.out.println("Tiden har gått ut");
        System.exit(0);
        }
    });
    cD.start();
    System.out.println();
    
    String input =s.nextLine();
   
    answered = true;
    System.out.println("Du svarde: " + input);
    s.close();
    }
        public static void main(String[] args) {
            countDown(10);
        }
    
 //a   
}