import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in); 
    Gameplay play = new Gameplay(); 
    Variables vars = new Variables();
    UI ui = new UI();
    
    public void launchMenu(){
        
        while (vars.exit){
            ui.printMenuUI();
            userMenuIn();
        }
        
        s.close();
    }
   
    public void userMenuIn(){

        do { 
        
        String userMenuIn = s.next();
        System.out.print("\033[1A");
        System.out.print("");
        

        if (!userMenuIn.matches("[1-4]")) {
                System.out.println("Ogiltigt menyval!");
                vars.userMenuInBo = false;
                continue;
        }

        switch (userMenuIn) {
                case "1" -> play.playRound();
                case "2" -> userHigh();
                case "3" -> userRules();
                case "4" -> userEx();
                default  -> {
                    System.out.println("Ogiltigt menyval!"); 
                }
            }
        } while (!vars.userMenuInBo);
    }

    public void userHigh(){

        System.out.println("Rekord Test");
        launchMenu();

    }

    public void userRules(){

        System.out.println("Spelregler Test");
        launchMenu();

    }

    public void userEx(){
        
        vars.exit = false;
        System.out.println(ui.tack);

    }

}