import java.util.Scanner;

public class Gameplay {

    private Score scoreTracker = new Score();
    public  void playRound(){
        
        
        
        Variables vars = new Variables(); 
        UI ui = new UI();
        Scanner s = new Scanner(System.in);
        Questions q = new Questions();

        while (vars.numberOfRounds < 3) {

            ui.printUI();

            
            
            
            System.out.print("Välj en fråga (t.ex. a1 - a6): ");
        
                do {
                    vars.userIn = s.next().toLowerCase();
                    vars.inputOK = inputCheck(vars.userIn);
                    
                    if (vars.inputOK == false) {
                        System.out.print("Felaktig input! Vänligen försök igen: ");
                    } else {
                                
                    }
                
                } while (!vars.inputOK);
        
        String[] question = q.getQuestion(vars.userIn);

        ui.editUI(vars.userIn); 

            for (int i = 0; i < 4; i++) {
                System.out.println(question[i]);
            }

        System.out.print("Svar: ");
        String answer = s.next();

        // Poängberäkning, Hämtar värdet i tex 1 i tex A1
char questionIndexChar = vars.userIn.charAt(1);
int questionIndex = Character.getNumericValue(questionIndexChar) -1;
int pointsEarned; 

            if (answer.equals(question[4])) {
                // hämtar poäng från Array.
                pointsEarned=Variables.storeScore[questionIndex];
                System.out.println("Korrekt svar, du får "+ pointsEarned+ " poäng!");
                
            } else {
                System.out.println("lol fel!"); 
                pointsEarned = 0;
            }
            scoreTracker.addPoints(pointsEarned);
            System.out.println("Aktuell poängställning " + scoreTracker.getTotalScore());

            vars.numberOfRounds++;
            
        }
    
            if (vars.numberOfRounds == 3){
                System.out.println("nu har du slut på antal rundor");
        }
    }

    public boolean inputCheck(String input) {

        if (input == null || input.length() < 2) {
        return false;
    }
        char category = input.charAt(0);
        int questionIndex = Character.getNumericValue(input.charAt(1));
            
        return !(category < 'a' || category > 'f' || questionIndex < 1 || questionIndex > 6);
            }
}