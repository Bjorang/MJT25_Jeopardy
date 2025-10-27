import java.util.Scanner;

public class Menu {
    private final Scanner s = new Scanner(System.in);
    private final Variables vars;
    private final Gameplay play;
    private final UI ui;

    public Menu() {
        this.vars = new Variables();
        this.ui = new UI(vars);
        this.play = new Gameplay(vars);
    }

    public void launchMenu() {
        ui.printMenuUI();
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
                case "1" -> play.playRound();
                case "2" -> userHigh();
                case "3" -> userRules();
                case "4" -> userEx();
                default -> System.out.println("Ogiltigt menyval!");
            }
        } while (!vars.userMenuInBo);
    }

    public void userHigh() {
        ui.clearScreen();
        ui.printMenuUI();

        System.out.println("Rekord Test");
        System.out.println("Nuvarande totalpoäng: " + vars.totalScore);
        launchMenu();
    }

    public void userRules() {
        ui.clearScreen();

        System.out.println("Spelregler Test");
        launchMenu();
    }

    public void userEx() {
        ui.clearScreen();

        System.out.println("Tack för att du spelade!");
        System.exit(0);
    }
}