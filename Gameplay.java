import java.util.Scanner;

public class Gameplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correctAnswer = "hej";

        String userInput = sc.nextLine().toLowerCase();
        boolean  isCorrect= userInput.equals(correctAnswer);
        
        for (int i = 0; i < 3; i++){
            
            if (isCorrect){
                System.out.println("nu lyckades du din jävel");
            }

            else {
                System.out.println("nu gick det inte");
                break;
            }
    }
    sc.close();  
}

  
}