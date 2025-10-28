import java.util.*;

public class Gameplay {

    Scanner s = new Scanner(System.in);
    Variables vars;
    UI ui;
    Questions q;
    Menu menu;

    public Gameplay(Variables vars) {
        this.vars = vars;
        this.ui = new UI(vars); 
        this.q = new Questions();
    }

    public void playRound() {

        while (vars.numberOfRounds < 6) {

            ui.clearScreen(); //Städar terminalen för en ny runda.
            ui.printGridUI(); //Printar spelplanen.

            userInput(); //Tar in användarens val av fråga och ser till att Stringen är korekt.
            isDouble(); //Kollar om användaren han chans på dubbel poäng men en slumpgenerator.

            vars.currentQuestion = q.getQuestion(vars.userInput); //Hämtar frågan användaren valt.
            ui.editGridUI(vars.userInput); //Redigerar bort rutan på spelplanen som användaren valt.

            vars.answered.set(false); //Sätter ett falsk värde som Threaden använder för att hålla kolla på spelets countdown timer. 

            countdown(10); //Startar timern för användaren. 
            
            vars.answer = ui.printQuestion(vars.currentQuestion, s); //Printar frågan.
            vars.answered.set(true); //stoppar timern när ett svar kommit.

            userAnswer(); //Rättar svares som användaren matade in och hanterar poängen.
            vars.numberOfRounds++; //Räknar vilken runda vi är på.

        }

        endGame(); //Printar ut spelarens slutpoäng, låter användaren skriva in sitt namn på rekordlistan och skickar sedan tillbaka dem till huvudmenyn. 
    }

    public void userInput() {

        do {
            vars.userInput = s.next().toLowerCase();
            vars.inputOK = checkInput(vars.userInput);

            if (!vars.inputOK) {
                System.out.print("Felaktig input! Vänligen försök igen: ");
            }
        } while (!vars.inputOK);
    }

    public boolean checkInput(String input) {
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

    public void isDouble() {

        vars.doubbleOrNot = false;
        vars.randomNum = (int)(Math.random() * 36 + 1); 
        
        if (vars.randomNumQ >= 4) {
            vars.doubbleOrNot = false;
        } else if (vars.randomNum <= 12) {
            vars.doubbleOrNot = true;
            vars.randomNumQ++; 
            
        if (vars.doubbleOrNot == true) {
            System.out.println("");
            System.out.println("WOW! Denna frågan har dubbel poäng!");
            System.out.println("");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {}

            }
        }   
    }

    public void isDouble() {

        vars.doubbleOrNot = false;
        vars.randomNum = (int)(Math.random() * 36 + 1); 
        
        if (vars.randomNumQ >= 4) {
            vars.doubbleOrNot = false;
        } else if (vars.randomNum <= 12) {
            vars.doubbleOrNot = true;
            vars.randomNumQ++; 
            
        if (vars.doubbleOrNot == true) {
        try {
            System.out.println("\nWOW! Denna frågan har dubbel poäng!");
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
        }
            

            }
        }   
    }

    public Thread countdown (int start) {
        
        Thread cD = new Thread(() -> {

            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {}

            for (int i = start; i >= 0; i--) {
                if (vars.answered.get()) {
                    return;
                } else {
                    System.out.print("\rTid kvar: " + vars.countdown[i] + " - Ditt svar: ");
                    vars.scoreTime = i;
                } 


            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {}
                    
        }

            if (!vars.answered.get()) {
                vars.scoreTime = 0;
                System.out.println("\n\nTiden har gått ut. Tryck 'valfritt tecken + enter'\n");
            }
        });

        cD.start();
        return cD;
    }

    public void userAnswer() { 
        char questionIndexChar = vars.userInput.charAt(1);
        int questionIndex = Character.getNumericValue(questionIndexChar) - 1;

        if (vars.answer.equals(vars.currentQuestion[4]) && (vars.scoreTime!=0) && (vars.doubbleOrNot == true)) {
            vars.pointsEarned = Variables.storeScore[questionIndex];
            vars.totalScore += vars.pointsEarned * 2;
            System.out.println("\nKorrekt svar, du får " + vars.pointsEarned * 2 + " poäng!!!\n");

        } else if (vars.answer.equals(vars.currentQuestion[4]) && (vars.scoreTime!=0)) {
            vars.pointsEarned = Variables.storeScore[questionIndex];
            vars.totalScore += vars.pointsEarned;
            System.out.println("\nKorrekt svar, du får " + vars.pointsEarned + " poäng!\n");

        } else if (vars.scoreTime == 0) {
            vars.pointsEarned = 0;
            System.out.println("\nTyvärr tog tiden slut! Rätt svar var: " + vars.currentQuestion[4] + "\n");

        } else {
            vars.pointsEarned = 0;
            System.out.println("\nFel svar! Rätt svar var: " + vars.currentQuestion[4] + "\n"); 
             
        } try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

    }

    public void endGame() {
        
        System.out.println("\nNu har du slut på antal rundor!\n");
        System.out.println("Din totala slutpoäng blev: " + vars.totalScore);

        ScoreBoard sBoard = new ScoreBoard();
        sBoard.saveScore(vars.playerOne, vars.totalScore);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        menu = new Menu();
        menu.launchMenu();
    }

}