import java.util.concurrent.atomic.AtomicBoolean;

public class Variables {

Variables vars;

int numberOfRounds = 0;
int preIndex = 0; 
int pointsEarned = 0;
int totalScore = 0;
int scoreTime = 0;

public static final int[] storeScore = {100,200,400,600,800,1000};

String userIn = "";
String answer = "";

public String[] questPre = new String[36];
public String[] currentQuestion;

String[][] questRowA = new String[6][5];
String[][] questRowB = new String[6][5];
String[][] questRowC = new String[6][5];
String[][] questRowD = new String[6][5];
String[][] questRowE = new String[6][5];
String[][] questRowF = new String[6][5];

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

String[] countdown = {" 0", " 1", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10"};

Boolean inputOK = true;
Boolean userMenuInBo = true;
Boolean exit = true;

AtomicBoolean answered = new AtomicBoolean(false);

String mainMenu = """


                        ▖▖▘▘▜ ▌               ▗ ▘▜ ▜ 
                        ▌▌▀▌▐ ▙▘▛▌▛▛▌▛▛▌█▌▛▌  ▜▘▌▐ ▐ 
                        ▚▘█▌▐▖▛▖▙▌▌▌▌▌▌▌▙▖▌▌  ▐▖▌▐▖▐▖
                                                
    ▗▖  ▗▖▗▄▄▄▖▗▖  ▗▖▗▄▄▄▖       ▗▖▗▄▄▄▖ ▗▄▖ ▗▄▄▖  ▗▄▖ ▗▄▄▖ ▗▄▄▄ ▗▖  ▗▖ ▗▖
    ▐▛▚▞▜▌▐▌   ▐▛▚▞▜▌▐▌          ▐▌▐▌   ▐▌ ▐▌▐▌ ▐▌▐▌ ▐▌▐▌ ▐▌▐▌  █ ▝▚▞▘  ▐▌
    ▐▌  ▐▌▐▛▀▀▘▐▌  ▐▌▐▛▀▀▘       ▐▌▐▛▀▀▘▐▌ ▐▌▐▛▀▘ ▐▛▀▜▌▐▛▀▚▖▐▌  █  ▐▌   ▐▌
    ▐▌  ▐▌▐▙▄▄▖▐▌  ▐▌▐▙▄▄▖    ▗▄▄▞▘▐▙▄▄▖▝▚▄▞▘▐▌   ▐▌ ▐▌▐▌ ▐▌▐▙▄▄▀  ▐▌   ▗▖                                                                                           
      
      Programerat av: Anders Björäng, Elizabeth Malm, och Peter Janstad                                                         
                                                                                                                                   
                                                           
                                                            
        ▖▖▘▘  ▜ ▘          ▘▘▜  ▘       ▌   ▌      ▘▜ ▜     ▘▘     
        ▌▌▀▌▛▌▐ ▌▛▌█▌▛▌  ▌▌▀▌▐  ▌  ▌▌▀▌▛▌  ▛▌▌▌  ▌▌▌▐ ▐   ▛▌▛▌▛▘▀▌▖
        ▚▘█▌▌▌▐▖▌▙▌▙▖▌▌  ▚▘█▌▐▖ ▌  ▚▘█▌▙▌  ▙▌▙▌  ▚▘▌▐▖▐▖  ▙▌▙▌▌ █▌▖
                 ▄▌            ▙▌                         ▄▌       
                                                            
                                                        
                                                                                                
                                  ▄▖    ▜                                              
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
}