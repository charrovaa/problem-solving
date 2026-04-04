import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            for (int count = 0; count < n; count++) {
                int size = Integer.parseInt(br.readLine());
                int[][] arr = new int[2][size]; // 입력
                int[][] values = new int[2][size]; // 해당 원소를 포함할 경우의 최대

                for (int i = 0; i < 2; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < size; j++) {
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                values[0][0] = arr[0][0];
                values[1][0] = arr[1][0];

                if (size == 1) {
                    bw.append(Integer.toString(Math.max(values[0][0], values[1][0])) + "\n");
                    continue;
                }

                values[0][1] = values[1][0] + arr[0][1];
                values[1][1] = values[0][0] + arr[1][1];

                if (size == 2) {
                    bw.append(Integer.toString(Math.max(values[0][1], values[1][1])) + "\n");
                    continue;
                }

                for (int i = 2; i < size; i++) {
                    values[0][i] = Math.max(values[1][i - 1], values[1][i - 2]) + arr[0][i];
                    values[1][i] = Math.max(values[0][i - 1], values[0][i - 2]) + arr[1][i];
                }
                bw.append(Integer.toString(Math.max(values[0][size - 1], values[1][size - 1])) + "\n");
            }
        }
    }
}