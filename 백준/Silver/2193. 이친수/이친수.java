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
            long[][] arr = new long[n + 1][2]; // [자릿수][마지막 자리 숫자]
            long sum = 0;

            arr[1][1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 2; j++) { // 0, 1
                    if (j == 0) {
                        arr[i][j] = arr[i - 1][1] + arr[i - 1][0];
                    } else {
                        arr[i][j] = arr[i - 1][0];
                    }
                }
            }

            for (long i : arr[n]) {
                sum += i;
            }

            bw.append(Long.toString(sum));
        }
    }
}