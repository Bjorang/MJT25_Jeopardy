import java.util.Scanner;

public class Gameplay {
    public  void playRound(){
        
        Variables vars = new Variables(); 
        UI ui = new UI();
        
        while (vars.numberOfRounds < 3) {

            ui.printUI();

            Scanner s = new Scanner(System.in);
            Questions q = new Questions();
            
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

            if (answer.equals(question[4])) {
                System.out.println("OMFG DU HADE RÄTT!!!");
            } else {
                System.out.println("lol fel!"); 
            }
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