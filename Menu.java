import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in);
    Variables vars;
    Gameplay play;
    UI ui;

    public Menu() {
        this.vars = new Variables();
        this.ui = new UI(vars);
        this.play = new Gameplay(vars);
    }

    public void launchMenu() {
        ui.clearScreen();
        System.out.print(vars.mainMenu + vars.space);
        userMenuIn();
    }

    public void userMenuIn() {
        do {
            String userMenuIn = s.next();

            if (!userMenuIn.matches("[1-4]")) {
                System.out.println("Ogiltigt menyval!");
                vars.userMenuInBo = false;
                continue;
            }

            switch (userMenuIn) {
                case "1" -> {
                    s.nextLine();
                    System.out.print("Ange ditt namn: ");
                    vars.playerOne = s.nextLine().trim();
                    vars.totalScore = 0;
                    play.playRound();}
                case "2" -> userHigh();
                case "3" -> userRules();
                case "4" -> userEx();
                default -> System.out.println("Ogiltigt menyval!");
            }
        } while (!vars.userMenuInBo);
    }

    public void userHigh() {
        ui.clearScreen();
        ScoreBoard sBoard = new ScoreBoard();
        sBoard.displayHighScore();

        System.out.print("\nTryck på valfri tangent för att återgå till menyn: ");
        s.next();
        launchMenu();
    }

    public void userRules() {
        ui.clearScreen();
        System.out.print("\n" + vars.rules + vars.space);
        s.next();
        launchMenu();
    }

    public void userEx() {
       
        ui.clearScreen();
        
        System.out.println("\n" + vars.tack);
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {}    
            
        s.close();
        ui.clearScreen();
        System.exit(0);
    }

}