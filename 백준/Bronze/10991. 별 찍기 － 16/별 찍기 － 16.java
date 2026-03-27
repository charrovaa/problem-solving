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
                for (int b = i; b < n; b++) {
                    bw.append(" ");
                }
                boolean flag = true;
                for (int s = 0; s < i * 2 - 1; s++) {
                    if (flag) {
                        flag = false;
                        bw.append("*");
                    } else {
                        flag = true;
                        bw.append(" ");
                    }
                }
                bw.append("\n");
            }
        }
    }
}