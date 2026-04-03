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
            int[][] arr = new int[n + 1][10];
            int sum = 0;

            for (int i = 0; i < 10; i++) { // 0 - 9
                arr[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 10; j++) {
                    int k = j;
                    while (k >= 0) {
                        arr[i][j] += arr[i - 1][k--] % 10007;
                    }
                }
            }

            for (int i : arr[n]) {
                sum += i;
            }

            bw.append(Integer.toString(sum % 10007));
        }
    }
}