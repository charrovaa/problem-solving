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
            int[] values = new int[n + 1]; // 입력
            int[] maxSums = new int[n + 1]; // 각 계단을 선택한 경우의 최댓값

            for (int i = 1; i <= n; i++) {
                values[i] = Integer.parseInt(br.readLine());
            }
            
            if (n >= 1) maxSums[1] = values[1];
            if (n >= 2) maxSums[2] = Math.max(values[1] + values[2], values[2]);

            for (int i = 3; i <= n; i++) {
                maxSums[i] = Math.max(values[i - 1] + maxSums[i - 3], maxSums[i - 2]) + values[i];
            }

            bw.write(String.valueOf(maxSums[n]));
        }
    }
}