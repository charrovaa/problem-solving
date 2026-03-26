import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input;
            while ((input = reader.readLine()) != null) {
                String[] inputs = input.trim().split("\\s+");
                System.out.println(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]));
            }
        } catch (IOException e) {

        }
    }
}