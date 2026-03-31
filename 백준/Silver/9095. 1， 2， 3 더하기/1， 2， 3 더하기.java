import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int[] arr = new int[11]; // 1 - 10
            arr[0] = 1;
            for (int i = 1; i < 11; i++) {
                int on = i - 1 < 0 ? 0 : arr[i - 1];
                int tw = i - 2 < 0 ? 0 : arr[i - 2];
                int th = i - 3 < 0 ? 0 : arr[i - 3];
                arr[i] = on + tw + th;
            }
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                bw.append(Integer.toString(arr[Integer.parseInt(br.readLine())]));
                bw.append("\n");
            }
        }
    }
}