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
            arr[1] = 0;
            for (int i = 2; i <= n; i++) {

                int min = arr[i - 1];

                if (i % 3 == 0) {
                    int f = arr[i / 3];
                    min = Math.min(min, f);
                }
                if (i % 2 == 0) {
                    int s = arr[i / 2];
                    min = Math.min(min, s);
                }

                arr[i] = min + 1;
            }

            bw.append(Integer.toString(arr[n]));
        }
    }
}