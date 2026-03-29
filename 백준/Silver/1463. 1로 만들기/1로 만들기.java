import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1]; 
            arr[1] = 0;
            for (int i = 2; i <= n; i++) {
                int f = Integer.MAX_VALUE;
                int s = Integer.MAX_VALUE;
                int t;
                if (i % 3 == 0) {
                    f = arr[i / 3];
                }
                if (i % 2 == 0) {
                    s = arr[i / 2];
                }
                t = arr[i - 1];

                arr[i] = IntStream.of(f, s, t).min().getAsInt() + 1;
            }

            bw.append(Integer.toString(arr[n]));
        }
    }
}