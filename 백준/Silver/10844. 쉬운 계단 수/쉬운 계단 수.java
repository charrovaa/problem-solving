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
            int[][] arr = new int[n + 1][10]; // [n][0 - 9]
            long sum = 0;

            for (int i = 1; i < 10; i++) {
                arr[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        arr[i][j] = arr[i - 1][j + 1];
                    } else if (j == 9) {
                        arr[i][j] = arr[i - 1][j - 1];
                    } else {
                        arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1_000_000_000;
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                sum += arr[n][i];
            }

            bw.append(Long.toString(sum % 1_000_000_000));
        }
    }
}