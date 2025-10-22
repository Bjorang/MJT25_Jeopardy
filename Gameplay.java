import java.util.Scanner;

public class Gameplay {
    public  void playRound(){
        
        int numberOfRounds = 0;
        UI ui = new UI();
        
        while (numberOfRounds < 3) {

        ui.printUI();

        Scanner s = new Scanner(System.in);
        Questions q = new Questions();

        System.out.print("Välj en fråga (t.ex. a1 - a6): ");
        String userIn = s.next().toLowerCase();
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
}