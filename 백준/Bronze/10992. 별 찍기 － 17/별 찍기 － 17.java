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
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < n + i; j++) {
                    if (i == n || j == n - i + 1 || j == n + i - 1) {
                        bw.append("*");
                        continue;
                    }
                    bw.append(" ");
                }
                bw.append("\n");
            }
        }
    }
}