import java.util.*;

public class Main {
    public static void main(String[] args) {

        UI ui = new UI();
        ui.printUI();

        Scanner s = new Scanner(System.in);
        Questions q = new Questions();

        String userIn = "";
        String[] question = q.getQuestion(userIn);

        for (int i = 0; i < 4; i++) {
            System.out.println(question[i]);
            
        }
        
    }
}