import java.util.*;
import java.io.*;

public class ScoreBoard {
    private Variables vars;
    List <String> list = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    
    private static final String highScorePole = "highScorePole.txt";

    public ScoreBoard(Variables vars) {
        this.vars = vars;
    }
    
    public void runScoreBoard(){
    
    
    System.out.println("Skriv in ditt namn");
    String playerOne = s.nextLine();
    int finalScore = vars.totalScore;
    
    
    System.out.println(finalScore + playerOne);

    

    try {
        Scanner fileReader = new Scanner (new File(highScorePole));
        while (fileReader.hasNextLine()) {
            list.add(fileReader.nextLine());
            
        }
        fileReader.close();
    } catch (IOException e) {
        System.out.println("");
    }
    
    list.add(playerOne+ ":"+ finalScore);

    Collections.sort(list,(a, b) -> Integer.parseInt(b.split(":")[1]) - Integer.parseInt(a.split(":")[1]));
    
    try {
        PrintWriter writer = new PrintWriter(new FileWriter(highScorePole));
        for (String line : list) writer.println(line);
        writer.close(); 

    } catch (IOException e) {
        System.out.println("Ops, något blev fel vid inmatning till filen");
    }
    
    showHighScore();

    boolean topTre = false;
    for (int i = 0; i < Math.min(3, list.size()); i++){
        if(list.get(i).startsWith(playerOne + ":")) topTre =true;
        

    else System.out.println("Tyvärr ditt scorer tar dig inte till top 3 på listan");
    
    }
   
    public void showHighScore(){
        
        System.out.println("====Highscore over time====");

    for (int i = 0; i < Math.min(3, list.size()); i++){
        System.out.println((i + 1)+ ". "+ list.get(i).replace(":", "-"));
        System.out.println("Tryck enter för att återgå");
        String x = s.nextLine();
    }
    
    }
}
