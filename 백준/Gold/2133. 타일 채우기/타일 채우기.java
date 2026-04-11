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
            int dp[] = new int[n + 1];

            if (n % 2 == 1) {
                bw.write(String.valueOf(0));
                return;
            }

            dp[0] = 1;

            for (int i = 2; i <= n; i += 2) { // 3*n인 경우 경우의 수
                for (int j = 0; j <= i; j += 2) { // 오른쪽 블록의 최소 단위
                    int rvalue = j == 2 ? 3 : 2;
                    dp[i] += dp[i - j] * rvalue;
                }
            }
            bw.write(String.valueOf(dp[n]));
        }
    }
}