import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StreamTokenizer st = new StreamTokenizer(br);
            st.nextToken();
            for (int i = 0; i < st.nval; i++) {
                for (int j = 1; j < st.nval - i; j++) {
                    bw.append(" ");
                }
                for (int j = 0; j <= i; j++) {
                    bw.append("*");
                }
                bw.append("\n");
            }
        }
    }
}