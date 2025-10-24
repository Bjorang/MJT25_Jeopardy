import java.util.Scanner;

public class UI {

    
        String mainMenu = """


                        ▖▖▘▘▜ ▌               ▗ ▘▜ ▜ 
                        ▌▌▀▌▐ ▙▘▛▌▛▛▌▛▛▌█▌▛▌  ▜▘▌▐ ▐ 
                        ▚▘█▌▐▖▛▖▙▌▌▌▌▌▌▌▙▖▌▌  ▐▖▌▐▖▐▖
                                                
    ▗▖  ▗▖▗▄▄▄▖▗▖  ▗▖▗▄▄▄▖       ▗▖▗▄▄▄▖ ▗▄▖ ▗▄▄▖  ▗▄▖ ▗▄▄▖ ▗▄▄▄ ▗▖  ▗▖ ▗▖
    ▐▛▚▞▜▌▐▌   ▐▛▚▞▜▌▐▌          ▐▌▐▌   ▐▌ ▐▌▐▌ ▐▌▐▌ ▐▌▐▌ ▐▌▐▌  █ ▝▚▞▘  ▐▌
    ▐▌  ▐▌▐▛▀▀▘▐▌  ▐▌▐▛▀▀▘       ▐▌▐▛▀▀▘▐▌ ▐▌▐▛▀▘ ▐▛▀▜▌▐▛▀▚▖▐▌  █  ▐▌   ▐▌
    ▐▌  ▐▌▐▙▄▄▖▐▌  ▐▌▐▙▄▄▖    ▗▄▄▞▘▐▙▄▄▖▝▚▄▞▘▐▌   ▐▌ ▐▌▐▌ ▐▌▐▙▄▄▀  ▐▌   ▗▖                                                                                           
                                                                       
                                                                                                                                   
                                                           
                                                            
        ▖▖▘▘  ▜ ▘          ▘▘▜  ▘       ▌   ▌      ▘▜ ▜     ▘▘     
        ▌▌▀▌▛▌▐ ▌▛▌█▌▛▌  ▌▌▀▌▐  ▌  ▌▌▀▌▛▌  ▛▌▌▌  ▌▌▌▐ ▐   ▛▌▛▌▛▘▀▌▖
        ▚▘█▌▌▌▐▖▌▙▌▙▖▌▌  ▚▘█▌▐▖ ▌  ▚▘█▌▙▌  ▙▌▙▌  ▚▘▌▐▖▐▖  ▙▌▙▌▌ █▌▖
                 ▄▌            ▙▌                         ▄▌       
                                                            
                                                        
                                                                                                
                            ▗     ▄▖    ▜                                              
                            ▜     ▚ ▛▌█▌▐ ▀▌                                           
                            ▟▖▗   ▄▌▙▌▙▖▐▖█▌                                           
                                    ▌                                                  
                            ▄▖    ▄▖  ▌      ▌                                         
                            ▄▌    ▙▘█▌▙▘▛▌▛▘▛▌                                         
                            ▙▖▗   ▌▌▙▖▛▖▙▌▌ ▙▌                                         
                                                                                    
                            ▄▖    ▄▖    ▜       ▜                                      
                            ▄▌    ▚ ▛▌█▌▐ ▛▘█▌▛▌▐ █▌▛▘                                 
                            ▄▌▗   ▄▌▙▌▙▖▐▖▌ ▙▖▙▌▐▖▙▖▌                                  
                                    ▌         ▄▌     
                            ▖▖    ▄▖    ▜   ▗   
                            ▙▌    ▌▌▌▌▛▘▐ ▌▌▜▘▀▌
                             ▌▗   ▛▌▚▘▄▌▐▖▙▌▐▖█▌
                    
    """;


        String tack = """
                        ▄▖    ▌   ▐▘▘▘      ▗ ▗    ▌          ▜    ▌  ▌
                        ▐ ▀▌▛▘▙▘  ▜▘▛▌▛▘  ▀▌▜▘▜▘  ▛▌▌▌  ▛▘▛▌█▌▐ ▀▌▛▌█▌▌
                        ▐ █▌▙▖▛▖  ▐ ▙▌▌   █▌▐▖▐▖  ▙▌▙▌  ▄▌▙▌▙▖▐▖█▌▙▌▙▖▖
                                                          ▌            
            """;

    
        String[] cat_u = {"      [A]   ","   [B]   ","   [C]  ", "    [D] ", "     [E]  ","    [F]",};
        String[] cat_0 = {"   [Animals]","[ Films ]","[ Games ]","[ Music ]","[ Anime ]","[   TV  ]",};
        String[] cat_00 = {"[1]","[2]","[3]","[4]","[5]","[6]",};
        String[] cat_01 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[  1000 ]",};
        String[] cat_02 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[  1000 ]",};
        String[] cat_03 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[  1000 ]",};
        String[] cat_04 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[  1000 ]",};
        String[] cat_05 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[  1000 ]",};
        String[] cat_06 = {"[  100  ]","[  200  ]","[  400  ]","[  600  ]","[  800  ]","[  1000 ]",};
    
        String[][] catt = {cat_u, cat_0,};
        String[][] cats = {cat_00, cat_01, cat_02, cat_03, cat_04, cat_05, cat_06,};
        
        public void printMenuUI(){
            
            System.out.println(mainMenu);

        }

        public void printUI(){
        
        for (int x = 0 ; x < catt.length; x++) {
            for (int y = 0; y < catt[x].length; y++) {
                System.out.print(catt[x][y]);
            }
            System.out.println("");
        }
        
        for (int y = 0 ; y < cats[0].length; y++) {
            for (int x = 0; x < cats.length; x++) {
                System.out.print(cats[x][y]);
            }
            System.out.println("");
        }
        
        System.out.println("");
        System.out.print("Välj en fråga (t.ex. a1 - a6): ");
    
    }

        public void editUI(String input){
            
    char category = input.charAt(0);
    int questionIndex = Character.getNumericValue(input.charAt(1)) - 1;

        if (category < 'a' || category > 'f' || questionIndex < 0 || questionIndex >= cat_01.length) {
            System.out.println("Wrong UI Input"); 
            return;
        }

    String[] selectedCategory;
        switch (category) {
            case 'a' -> selectedCategory = cat_01;
            case 'b' -> selectedCategory = cat_02;
            case 'c' -> selectedCategory = cat_03;
            case 'd' -> selectedCategory = cat_04;
            case 'e' -> selectedCategory = cat_05;
            case 'f' -> selectedCategory = cat_06;
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
