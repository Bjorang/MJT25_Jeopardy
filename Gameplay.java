import java.util.Scanner;

public class Gameplay {
    public void playRound(){
        Scanner sc = new Scanner(System.in);
        String correctAnswer = "hej";
        int numberOfRounds = 0;
        
        
        while (numberOfRounds < 3) {

            UI ui = new UI();
            ui.printUI();
            System.out.println("Välj vilken fråga du vill svara på genom att skriva bokstav för kolumnen samt siffra ,t.ex. 'A3'");

            String userInput = sc.nextLine();
            boolean  isCorrect= userInput.equals(correctAnswer);
            if (isCorrect){
                System.out.println("nu lyckades du din jävel");
                break;
            }

            else {
                System.out.println("nu gick det inte");
                numberOfRounds++;
            }
        }

   if (numberOfRounds == 3){

    System.out.println("nu har du slut på antal rundor");
   }
   sc.close();
    }
}

  
