import java.util.*;

public class Gameplay {

    private final Scanner s = new Scanner(System.in);
    private final Score scoreTracker = new Score();
    private final Variables vars;
    private final UI ui;
    private final Questions q;
    private Menu menu;

    public Gameplay(Variables vars) {
        this.vars = vars;
        this.ui = new UI(vars); 
        this.q = new Questions();
    }

    public void playRound() {

        vars.numberOfRounds = 0;

        while (vars.numberOfRounds < 5) {

            ui.clearScreen();
            ui.printGridUI();

            userIn();
            vars.currentQuestion = q.getQuestion(vars.userIn);
            ui.editGridUI(vars.userIn);

            vars.answered.set(false);
            countDown(10);
            vars.answer = ui.printQuestion(vars.currentQuestion, s);
            vars.answered.set(true);

            Thread timer = countDown(10);
            try {
                timer.join();  
            } catch (InterruptedException e) {
                e.printStackTrace();     
            }

            userAnswer();
            vars.numberOfRounds++;

        }

        endGame();
    }

    public void userIn() {

        do {
            vars.userIn = s.next().toLowerCase();
            vars.inputOK = inputCheck(vars.userIn);

            if (!vars.inputOK) {
                System.out.print("Felaktig input! Vänligen försök igen: ");
            }
        } while (!vars.inputOK);
    }

    public void userAnswer() { 
        char questionIndexChar = vars.userIn.charAt(1);
        int questionIndex = Character.getNumericValue(questionIndexChar) - 1;

        if (vars.answer.equals(vars.currentQuestion[4]) && (vars.scoreTime!=0)) {
            vars.pointsEarned = Variables.storeScore[questionIndex];
            vars.totalScore += vars.pointsEarned;

            System.out.println();
            System.out.println("Korrekt svar, du får " + vars.pointsEarned + " poäng!");
            System.out.println();
        } else if (vars.scoreTime == 0) {
            vars.pointsEarned = 0;
            System.out.println();
            System.out.println("Tyvärr tog tiden slut! Rätt svar var: " + vars.currentQuestion[4]);
            System.out.println();
        } else {
            vars.pointsEarned = 0;
            System.out.println();
            System.out.println("Fel svar! Rätt svar var: " + vars.currentQuestion[4]);
            System.out.println();  
        } 
            try {
                    Thread.sleep(3000);
                }       catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

    public Thread countDown(int start) {
        Thread cD = new Thread(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = start; i >= 0; i--) {
                
                if (vars.answered.get()) {
                    return;
                } else if (i>=0) {
                    System.out.print("\rTid kvar: " + vars.countdown[i] + " - Ditt svar: ");
                    vars.scoreTime = i;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println();
                }
            }

            if (!vars.answered.get()) {
                vars.scoreTime = 0;
                System.out.println();
                System.out.println();
                System.out.println("Tiden har gått ut");
                System.out.println();
            }
        });

        cD.start();
        return cD;
    }

    public void endGame() {
        
        System.out.println("");
        System.out.println("Nu har du slut på antal rundor!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        menu = new Menu();
        menu.launchMenu();
    }

}