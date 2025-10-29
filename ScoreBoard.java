import java.io.*;
import java.util.*;

public class ScoreBoard {

    private static final String highScorePole = "highScorePole.txt";

    public void saveScore(String playerOne, int finalScore) {
        List<String> list = loadScores();
        list.add(playerOne + ":" + finalScore);

        Collections.sort(list, (a, b) -> {
            try {
                return Integer.parseInt(b.split(":")[1]) - Integer.parseInt(a.split(":")[1]);
            } catch (Exception e) {
                return 0;
            }

        });
        writeScores(list);
        displayScores(list, playerOne);
    }

    public void displayHighScore() {
        List<String> list = loadScores();
        displayScores(list, null);
    }

    private List<String> loadScores() {
        List<String> list = new ArrayList<>();
        File file = new File(highScorePole);

        if (!file.exists()) {
            return list;
        }
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                list.add(fileReader.nextLine());

            }
        } catch (IOException e) {

        }
        return list;
    }

    private void writeScores(List<String> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(highScorePole))) {
            for (String line : list) {
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("Fel vid inmatning av fil");
        }
    }

    private void displayScores(List<String> list, String currentPlayer) {
        System.out.println("\n- Rekord top " + Math.min(10, list.size()) + " -\n");

        for (int i = 0; i < Math.min(10, list.size()); i++) {
            String entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.replace(":", " - "));
        }

        if (currentPlayer != null) {
            boolean topTre = false;
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                if (list.get(i).startsWith(currentPlayer + ":")) {
                    topTre = true;
                    break;
                }
            }
            if (topTre) {
                System.out.println("\nGrattis " + currentPlayer + "! Ditt score tog dig till top 3!");
            } else {
                System.out.println("\nTyvärr ditt score tar dig inte till top 3 på listan");
            }
        }

    }

}