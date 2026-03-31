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
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for (int i = 4; i < 11; i++) {
                arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
            }
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                bw.append(Integer.toString(arr[Integer.parseInt(br.readLine())]));
                bw.append("\n");
            }
        }
    }
}