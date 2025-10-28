import java.util.*;
import java.io.*;

public class ScoreBoard {
    
    private static final String highScorePole = "highScorePole.txt";
    
    public void runScoreBoard(Object getTotalScore){
    
    Scanner s = new Scanner(System.in);
    String playerOne = s.nextLine();
    Score score = new Score();
    int finalScore = score.getTotalScore();
    
    System.out.println(finalScore + playerOne);

    List <String> list = new ArrayList<>();

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

    System.out.println("====Highscore over time====");
    for(int i = 0; i < Math.min(3, list.size()); i++){
        System.out.println((i + 1)+ ". "+ list.get(i).replace(":", "-"));
    }

    boolean topTre = false;
    for (int i = 0; i < Math.min(3, list.size()); i++){
        if(list.get(i).startsWith(playerOne + ":")) topTre =true;
    }
    if (topTre) System.out.println("Grattis " + playerOne + "! Ditt score tar dig till top 3!");

    else System.out.println("Tyvärr ditt scorer tar dig inte till top 3 på listan");
    s.close();
    }

}
