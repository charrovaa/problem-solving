import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= (2 * n) - 1; i++) {
                int f = n - i < 0 ? - (n - i) : n - i;
                int t = f;
                for (; f < n; f++) {
                    bw.append("*");
                }
                for (int s = 0; s < t * 2; s++) {
                    bw.append(" ");
                }
                for (; t < n; t++) {
                    bw.append("*");
                }
                bw.append("\n");
            }
        }
    }
}