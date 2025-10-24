import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
public class Gameplay {

    private Score scoreTracker = new Score();
        
        
    Scanner s = new Scanner(System.in); 
    Variables vars = new Variables();
    Menu menu;

    private AtomicBoolean answered = new AtomicBoolean(false);
    
    public void playRound(){
         
        Questions q = new Questions();
        UI ui = new UI();
        
        

        while (vars.numberOfRounds < 3) {

        ui.printUI();

        userIn(); 

        vars.currentQuestion = q.getQuestion(vars.userIn);
          

        ui.editUI(vars.userIn);
        answered.set(false);
        countDown(10);

        vars.answer = ui.printQuestion(vars.currentQuestion, s);

        answered.set(true);

        userAnswer();

        vars.numberOfRounds++;

        }
        
        endGame();

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

    public void userAnswer(){
       
        char questionIndexChar = vars.userIn.charAt(1);
        int questionIndex = Character.getNumericValue(questionIndexChar) -1;

            if (vars.answer.equals(vars.currentQuestion[4])) {
                
                vars.pointsEarned=Variables.storeScore[questionIndex];
                System.out.println("Korrekt svar, du får "+ vars.pointsEarned+ " poäng!");
                
            } else {
                System.out.println("lol fel!"); 
                vars.pointsEarned = 0;
            }
          
        scoreTracker.addPoints(vars.pointsEarned);
        System.out.println("Aktuell poängställning " + scoreTracker.getTotalScore());
            
        }

    public void endGame(){
        
        System.out.println("nu har du slut på antal rundor");

        menu = new Menu(); 
        menu.launchMenu();
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

    public Thread countDown(int start){
        Thread cD = new Thread(() ->{
            for (int i = start; i >= 0; i--){
            
                if (answered.get()){
                    return;
                }

        System.out.print("\r Tid kvar: " + i + " Ditt svar: ");
            
            try {
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                System.out.println("");
            }
            
        }
        if(!answered.get()){
            System.out.println("");
            System.out.println("Tiden har gått ut");
            System.out.println("");       
        }
        
    });

        cD.start();
        return cD;

    }
}

