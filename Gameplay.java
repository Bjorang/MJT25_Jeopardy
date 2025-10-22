import java.util.Scanner;

public class Gameplay {
    public  void playRound(){
        int numberOfRounds = 0;
        UI ui = new UI();
        
        while (numberOfRounds < 3) {

        ui.printUI();

        Scanner s = new Scanner(System.in);
        Questions q = new Questions();
        String userIn = "";
        Boolean inputOK = false;
        System.out.print("Välj en fråga (t.ex. a1 - a6): ");
       
        do {
            userIn = s.next().toLowerCase();
            inputOK = inputCheck(userIn);
            System.out.println(inputOK);
            if (inputOK == false) {
                System.out.print("Felaktig input! Vänligen försök igen: ");
            } else {
        
            }
        
        } while (inputOK==false);
        
        String[] question = q.getQuestion(userIn);

        ui.editUI(userIn); 

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
            numberOfRounds++;
            
        }
    
        if (numberOfRounds == 3){
            System.out.println("nu har du slut på antal rundor");
        }
    }

    public boolean inputCheck(String input) {

        if (input == null || input.length() < 2) {
        return false;
    }
        char category = input.charAt(0);
        int questionIndex = Character.getNumericValue(input.charAt(1));
            
            if (category < 'a' || category > 'f' || questionIndex < 1 || questionIndex > 6) {
                    return false; 
                } else {
                    return true;
                    }
            }
}