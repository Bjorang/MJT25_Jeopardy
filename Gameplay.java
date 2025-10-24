import java.util.Scanner;
public class Gameplay {
    
    Scanner s = new Scanner(System.in); 
    Variables vars = new Variables();
    
    public void playRound(){
         
        Questions q = new Questions();
        UI ui = new UI();
        
        while (vars.numberOfRounds < 3) {

        ui.printUI();

        userIn(); 

        vars.currentQuestion = q.getQuestion(vars.userIn);

        ui.editUI(vars.userIn);

        vars.answer = ui.printQuestion(vars.currentQuestion, s);

        userAnswer();

        vars.numberOfRounds++;

        }
        
        endGame();

        s.close();

    } 

    public void userIn(){

        do {
            vars.userIn = s.next().toLowerCase();
            vars.inputOK = inputCheck(vars.userIn);
            
            if (vars.inputOK == false) {
                System.out.print("Felaktig input! Vänligen försök igen: ");
            }
        } while (!vars.inputOK);

    }

    public void userAnswer(){{

        if (vars.answer.equals(vars.currentQuestion[4])) {
            CountdownTimer.countDown(10);
                System.out.println("OMFG DU HADE RÄTT!!!");
            } else {
                System.out.println("lol fel!");
            }
        }
    }

    public void endGame(){
        
        if (vars.numberOfRounds == 3){
                System.out.println("nu har du slut på antal rundor"); 
        }
    }

    public boolean inputCheck(String input) {

        if (input.length() < 2) {
            return false;
        }

    char category = input.charAt(0);
    int questionIndex = Character.getNumericValue(input.charAt(1));

    boolean valid = !(category < 'a' || category > 'f' || questionIndex < 1 || questionIndex > 6);
        
        if (!valid) {
            return false;
        }

        for (int i = 0; i < vars.preIndex; i++) {
            if (input.equals(vars.questPre[i])) {
                System.out.println("Denna frågan har du redan valt!");
                return false;
            }
        }

    vars.questPre[vars.preIndex] = input;
    vars.preIndex++;

    return true;
    }

}