import java.util.Scanner;

public class UI {
        Variables vars = new Variables();
      
        public void printMenuUI(){
            
            System.out.println(vars.mainMenu);

        }

        public void printUI(){
        
        for (int x = 0 ; x < vars.catt.length; x++) {
            for (int y = 0; y < vars.catt[x].length; y++) {
                System.out.print(vars.catt[x][y]);
            }
            System.out.println("");
        }
        
        for (int y = 0 ; y < vars.cats[0].length; y++) {
            for (int x = 0; x < vars.cats.length; x++) {
                System.out.print(vars.cats[x][y]);
            }
            System.out.println("");
        }
        
        System.out.println("");
        System.out.print("Välj en fråga (t.ex. a1 - a6): ");
    
    }

        public void editUI(String input){
            
    char category = input.charAt(0);
    int questionIndex = Character.getNumericValue(input.charAt(1)) - 1;

        if (category < 'a' || category > 'f' || questionIndex < 0 || questionIndex >= vars.cat_01.length) {
            System.out.println("Wrong UI Input"); 
            return;
        }

    String[] selectedCategory;
        switch (category) {
            case 'a' -> selectedCategory = vars.cat_01;
            case 'b' -> selectedCategory = vars.cat_02;
            case 'c' -> selectedCategory = vars.cat_03;
            case 'd' -> selectedCategory = vars.cat_04;
            case 'e' -> selectedCategory = vars.cat_05;
            case 'f' -> selectedCategory = vars.cat_06;
            default  -> {
                System.out.println("Invalid question code!"); 
                return;
                }
            }
        
            selectedCategory[questionIndex] = "[       ]";
    
        }

        public String printQuestion(String[] question, Scanner s) {
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.println(question[i]);
            
        }
        

        System.out.print("Svar: ");
        return s.next();
    }
    
}