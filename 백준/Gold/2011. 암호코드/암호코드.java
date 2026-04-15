import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static final int MOD = 1_000_000;
	
	public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String s = br.readLine();

            int[] nums = new int[s.length() + 1];
            for (int i = 1; i <= s.length(); i++) nums[i] = s.charAt(i - 1) - '0';

            int[] dp = new int[s.length() + 1];

            if (nums[1] != 0) {
                dp[0] = dp[1] = 1;
                for (int i = 2; i <= s.length(); i++) {
                    // nums[i]가 한 자리 숫자인 경우
                    if (nums[i] != 0) {
                        dp[i] = dp[i - 1];
                    } else {
                        if (nums[i - 1] < 1 || nums[i - 1] > 2) {
                            break;
                        }
                    }
                    // nums[i - 1] nums[i]가 두 자리 숫자인 경우
                    int num = nums[i - 1] * 10 + nums[i];
                    if (num >= 10 && num <= 26) {
                        dp[i] = (dp[i] + dp[i - 2]) % MOD;
                    }
                }
            }
            bw.write(String.valueOf(dp[s.length()]));
        }
    }
}