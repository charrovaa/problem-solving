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

            int[] values = new int[n + 1];
            int[] selected = new int[n + 1]; // n 번째의 포도주를 선택한 경우
            int[] unselected = new int[n + 1]; // n 번째의 포도주를 선택하지 않은 경우

            for (int i = 1; i < n + 1; i++) {
                values[i] = Integer.parseInt(br.readLine());
            }

            selected[1] = values[1];
            unselected[1] = 0;

            for (int i = 2; i <= n; i++) {
                // n 선택 / n - 1 선택 / n - 2 미선택
                int a = values[i] + values[i - 1] + unselected[i - 2];
                // n 선택 / n - 1 미선택 / 모든 n - 2
                int b = values[i] + Math.max(selected[i - 2], unselected[i - 2]);
                // n 선택 경우의 수 최댓값
                selected[i] = Math.max(a, b);
                // n 미선택 / 모든 n - 1
                unselected[i] = Math.max(selected[i - 1], unselected[i - 1]);
            }

            bw.append(Integer.toString(Math.max(selected[n], unselected[n])));
        }
    }
}