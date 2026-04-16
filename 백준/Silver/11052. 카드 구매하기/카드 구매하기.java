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
            int n = Integer.parseInt(br.readLine()); // 구매할 카드의 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] price = new int[n + 1]; // n개의 카드가 들어있는 카드팩의 가격
            for (int i = 1; i <= n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[n + 1]; // 해당 카드 수가 (인덱스) 최대로 가질 수 있는 가격
            dp[0] = 0;
            dp[1] = price[1];

            for (int cards = 1; cards <= n; cards++) { // cards장 이하의 카드가 들어있는 팩만 사용
                for (int i = cards; i <= n; i++) { // 카드의 수
                    dp[i] = Math.max(dp[i], dp[i - cards] + price[cards]); // 기존의 방식 / 새롭게 추가된 카드팩이 적용된 방식
                }
            }
            bw.write(String.valueOf(dp[n]));
        }
    }
}