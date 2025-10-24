import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in); 
    Gameplay play = new Gameplay(); 
    Variables vars = new Variables();
    UI ui = new UI();
    
    public void launchMenu(){
    
    do { 

        ui.printMenuUI();

         userMenuIn();
        
    } while (!vars.exit);

    }

    public void userMenuIn(){

        do { 
        
        String userMenuIn = s.next();

        if (!"1".equals(userMenuIn) || !"2".equals(userMenuIn) || !"3".equals(userMenuIn)) {
            vars.userMenuInBo = false;
        }

        switch (userMenuIn) {
                case "1" -> play.playRound();
                case "2" -> play.playRound();
                case "3" -> play.playRound();
                default  -> {
                    System.out.println("Invalid Menu prompt!"); 
                }
            }
        } while (!vars.userMenuInBo);

    }

}