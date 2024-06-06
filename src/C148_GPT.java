import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C148_GPT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int numberOfBattles = Integer.parseInt(firstLine[0]);
        int myLevel = Integer.parseInt(firstLine[1]);

        for (int i = 0; i < numberOfBattles; i++){
            int enemyLevel = Integer.parseInt(reader.readLine());
            myLevel = simulateBattle(myLevel, enemyLevel);
        }
        System.out.println(myLevel);
    }

    private static int simulateBattle(int myLevel, int enemyLevel) {
        if (myLevel > enemyLevel) {
            myLevel += enemyLevel / 2;
        } else if (myLevel < enemyLevel) {
            myLevel /= 2;
        }
        // If levels are equal, no change in levels
        return myLevel;
    }
}
