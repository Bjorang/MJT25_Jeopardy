import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in);
    Variables vars = new Variables(); 
    Gameplay play = new Gameplay(); 
    UI ui = new UI();
    
    public void launchMenu(){
        
            ui.printMenuUI();
            userMenuIn();

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
        
        System.out.println(vars.tack);
        s.close();
        System.exit(1);

    }

}