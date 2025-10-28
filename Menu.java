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
        System.out.println(vars.mainMenu);
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
                    System.out.println("Ange ditt namn ");
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

        System.out.println("\nTryck på valfri tangent för att återgå till menyn...");
    s.next();
        //System.out.println("Nuvarande totalpoäng: " + vars.totalScore);
        launchMenu();
    }

    public void userRules() {
        ui.clearScreen();

        System.out.println("Spelregler Test");
        launchMenu();
    }

    public void userEx() {
       
        ui.clearScreen();
        
            for (int i = 0; i < 2; i++) {
        
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
            }
                    if (i==0) {
                        System.out.println(vars.tack);
                    }
            }
        s.close();
        ui.clearScreen();
        System.exit(0);
    }
}