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
            if (n == 1) {
                bw.append("1");
                return;
            } else if (n == 2) {
                bw.append("3");
                return;
            }
            int[] arr = new int[n + 1];
            arr[1] = 1;
            arr[2] = 3;
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i - 2] * 2 + arr[i - 1]) % 10007;
            }
            bw.append(Integer.toString(arr[n]));
        }
    }
}