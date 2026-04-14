import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] n = br.readLine().split("");
            int[] dp = new int[n.length]; dp[0] = 1;
            int MOD = 1_000_000;

            /*
            - 점화식
                1. dp[n] = dp[n - 1] + dp[n - 2]

            - 특별 케이스 : 마지막 글자 (n - 1, n)로 만든 숫자 Num에 대해서
                1. Num이 26을 초과하는 경우
                    1.1. n이 0인 경우 : 잘못된 암호
                    1.2. n이 0이 아닌 경우 : dp[n] = dp[n - 1]
                2. Num이 0 초과 26 이하인 경우
                    2.1. n - 1이 0인 경우 : dp[n] = dp[n - 3]
                    2.2. n - 1이 0이 아닌 경우 : dp[n] = dp[n - 1] + dp[n - 2]

            - 잘못된 암호
                1. 첫 글자가 0으로 시작하는 경우
                2. 0이 연속으로 나오는 경우 (Num이 0인 경우)
            */

            if (n[0].equals("0")) {
                bw.write("0");
                return;
            }

            for (int i = 1; i < n.length; i++) {

                int lastNum = Integer.parseInt(n[i - 1] + n[i]);

                if (lastNum == 0) {
                    bw.write("0");
                    return;
                }

                if (lastNum > 26) {
                    if (n[i].equals("0")) {
                        bw.write("0");
                        return;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else {
                    if (n[i].equals("0")) {
                        if (i < 2) {
                            dp[i] = 1;
                            continue;
                        }
                        dp[i] = dp[i - 2];
                    } else if (n[i - 1].equals("0")) {
                        if (i < 3) {
                            dp[i] = 1;
                            continue;
                        }
                        dp[i] = dp[i - 3];
                    } else {
                        if (i < 2) {
                            dp[i] = 2;
                            continue;
                        }
                        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                    } 
                }
            }
            bw.write(String.valueOf(dp[n.length - 1]));
        }
    }
}