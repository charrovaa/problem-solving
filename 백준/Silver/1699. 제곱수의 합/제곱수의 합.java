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
            int[] arr = new int[n + 1];

            arr[0] = 0; // 최소항의 개수

            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    int temp = arr[i - (j * j)] + 1; // 1 : j * j
                    if (temp < min) min = temp;
                }
                arr[i] = min;
            }

            bw.write(String.valueOf(arr[n]));
        }
    }
}