import java.util.concurrent.atomic.AtomicBoolean;

public class Variables {

    int numberOfRounds = 0;
    int preIndex = 0; 
    int pointsEarned;

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
    
    Boolean inputOK = true;
    Boolean userMenuInBo = true;
    Boolean exit = true;

    AtomicBoolean answered = new AtomicBoolean(false);
    
}
