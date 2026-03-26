import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StreamTokenizer st = new StreamTokenizer(br);
            int count = Integer.parseInt(br.readLine());
            double max = Integer.MIN_VALUE;
            double min = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                st.nextToken();
                double n = st.nval;
                if (max < n) {
                    max = n;
                }
                if (min > n) {
                    min = n;
                }
            }
            System.out.printf("%.0f %.0f", min, max);
        }
    }
}