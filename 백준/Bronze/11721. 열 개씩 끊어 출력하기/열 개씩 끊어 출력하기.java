import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] inputs = reader.readLine().split("");
            int count = 0;
            for (int i = 0; i < inputs.length; i++) {
                if (count == 10) {
                    count = 0;
                    System.out.println();
                }
                System.out.print(inputs[i]);
                count++;
            }
        } catch (IOException e) {

        }
    }
}