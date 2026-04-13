import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 합
            int k = Integer.parseInt(st.nextToken()); // 정수의 개수
            int[][] dp = new int[n + 1][k + 1];
            int MOD = 1_000_000_000;

            // 정수의 개수가 1개인 (나 자신) 경우
            for (int i = 1; i <= n; i++) {
                dp[i][1] = 1;
            }

            for (int i = 1; i <= k; i++) {
                // 합이 1인데 정수의 개수가 2 이상인 경우
                dp[1][i] = i;

                // 합이 0인데 정수의 개수가 2 이상인 경우
                dp[0][i] = 1;
            }

            // 새로운 숫자 추가 (마지막에 0을 두는 경우) + 이미 정해진 숫자의 크기 증가 (마지막 숫자에 1을 더하는 경우)
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= k; j++) {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                }
            }
            bw.write(String.valueOf(dp[n][k]));
        }
    }
}