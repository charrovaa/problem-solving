import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StreamTokenizer st = new StreamTokenizer(br);
            st.nextToken();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < st.nval; i++) {
                for (int j = 1; j < st.nval - i; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j <= i; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
}