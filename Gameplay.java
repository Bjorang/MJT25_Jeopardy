import java.util.Scanner;

public class Gameplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correctAnswer = Questions();

        UI ui = new UI();
        ui.printUI();
        String userInput = sc.nextLine().toLowerCase();
        boolean  isCorrect= userInput.equals(correctAnswer);

        int numberOfRounds = 0;
        
        while (numberOfRounds < 3) {

            if (isCorrect){
                System.out.println("nu lyckades du din jävel");
                break;
            }

            else {
                System.out.println("nu gick det inte");
                break;
            }
    }
    sc.close();  
}

  
}