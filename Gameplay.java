import java.util.Scanner;

public class Gameplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        
      
        String correctAnswer = "Hej";
        
        if (userInput.equals(correctAnswer)){
            System.out.println("nu lyckades du din jävel");
         

        }
        else {
            System.out.println("nu gick det inte");
     
        }
    sc.close();    
    }

   
}