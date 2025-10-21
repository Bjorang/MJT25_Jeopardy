import java.util.Scanner;

public class Gameplay {
    public  void playRound(){
        int numberOfRounds = 0;
        
        while (numberOfRounds < 3) {

            UI ui = new UI();
        ui.printUI();

        Scanner s = new Scanner(System.in);
        Questions q = new Questions();

        String userIn = "";
        String[] question = q.getQuestion(userIn);

        for (int i = 0; i < 4; i++) {
            System.out.println(question[i]);

        }

        System.out.print("Svar: ");

        String answer = s.next();
            if (answer.equals(question[4])) {
                System.out.println("OMFG DU HADDE RÄTT!!!");
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

  
