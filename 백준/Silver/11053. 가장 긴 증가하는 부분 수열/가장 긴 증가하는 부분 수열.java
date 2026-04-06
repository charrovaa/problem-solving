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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] values = new int[n + 1]; // 수열
            int[] lengths = new int[n + 1]; // 해당 값을 마지막으로 갖는 수열의 최대 길이
            for (int i = 1; i <= n; i++) {
                values[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                lengths[i] = 1; // 수열 초기 길이 (나 자신)
                for (int j = i - 1; j > 0; j--) {
                    if (values[j] < values[i]) { // 해당 수열에 포함할 수 있는 원소일 경우
                        if (lengths[j] >= lengths[i]) { // 이때까지의 최대 길이보다 길거나 같으면 (같아도 +1 연산으로 더 길어짐)
                            lengths[i] = lengths[j] + 1; // 최대 길이 + 나 자신
                        }
                    }
                }
            }
            int max = 0;
            for (int i : lengths) {
                if (i > max) max = i;
            }
            bw.append(Integer.toString(max));
        }
    }
}