import java.util.Scanner;

public class Menu {
    Scanner s = new Scanner(System.in); 
    Gameplay play = new Gameplay(); 
    
    public void launchMenu(){

    String logo = """





    
    
    ▗▖  ▗▖▗▄▄▄▖▗▖  ▗▖▗▄▄▄▖       ▗▖▗▄▄▄▖ ▗▄▖ ▗▄▄▖  ▗▄▖ ▗▄▄▖ ▗▄▄▄ ▗▖  ▗▖
    ▐▛▚▞▜▌▐▌   ▐▛▚▞▜▌▐▌          ▐▌▐▌   ▐▌ ▐▌▐▌ ▐▌▐▌ ▐▌▐▌ ▐▌▐▌  █ ▝▚▞▘ 
    ▐▌  ▐▌▐▛▀▀▘▐▌  ▐▌▐▛▀▀▘       ▐▌▐▛▀▀▘▐▌ ▐▌▐▛▀▘ ▐▛▀▜▌▐▛▀▚▖▐▌  █  ▐▌  
    ▐▌  ▐▌▐▙▄▄▖▐▌  ▐▌▐▙▄▄▖    ▗▄▄▞▘▐▙▄▄▖▝▚▄▞▘▐▌   ▐▌ ▐▌▐▌ ▐▌▐▙▄▄▀  ▐▌                                                                                              
    """;

        String introScreen = """
        ▖▖▘▘▜ ▌                            ▘           ▌  ▌        
        ▌▌▀▌▐ ▙▘▛▌▛▛▌▛▛▌█▌▛▌  ▛▛▌█▌▛▛▌█▌   ▌█▌▛▌▛▌▀▌▛▘▛▌▌▌▌        
        ▚▘█▌▐▖▛▖▙▌▌▌▌▌▌▌▙▖▌▌  ▌▌▌▙▖▌▌▌▙▖   ▌▙▖▙▌▙▌█▌▌ ▙▌▙▌▖        
                                        ▙▌    ▌       ▄▌         
                                                           
                                                           
                                                           
                                                            
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
    """;

    System.out.println(logo);

    System.out.println(introScreen);

    int userMenuIn = s.nextInt();

        switch (userMenuIn) {
            case 1 -> play.playRound();
            case 2 -> play.playRound();
            case 3 -> play.playRound();
            default  -> {
                System.out.println("Invalid Menue prompt!"); 
                return;
                }
            }
    }
}