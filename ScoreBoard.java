import java.util.*;
import java.io.*;

public class ScoreBoard {
    
    private static final String highScoreList = "highScoreList.txt";
    
    public void runScoreBoard(Object getTotalScore){
    
    Scanner s = new Scanner(System.in);
    String playerOne = s.nextLine();
    Score score = new Score();
    int finalScore = score.getTotalScore();
    
    System.out.println(finalScore + playerOne);
    s.close();
    }

}
