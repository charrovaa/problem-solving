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
            long[][] dp = new long[n + 2][k + 1];

            /*
            1. ㅁ을 1로 계산하여 정수의 합 표현
            2. _를 ㅁ 사이에 배치해 각 정수의 크기를 결정
            3. 제일 마지막 _ 고정
            예시 : ㅁ_ _ㅁㅁ_ㅁ_ = 1 + 0 + 2 + 1
            */

            //dp[i][j] : i까지 j개를 고른 경우

            for (int i = 0; i < n + 2; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= n + 1; i++) { // 선택지 n + 1개 중
                for (int j = 1; j <= k - 1; j++) { // k - 1개 선택
                    for (int l = 0; l <= j; l++) {
                        dp[i][j] += dp[i - 1][j - l];
                        dp[i][j] %= 1_000_000_000;
                    }
                }
            }

            bw.write(String.valueOf(dp[n + 1][k - 1]));
        }
    }
}