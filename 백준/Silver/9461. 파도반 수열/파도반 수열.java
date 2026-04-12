import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<BigInteger> dp = new ArrayList<>();
            dp.add(BigInteger.valueOf(0));
            dp.add(BigInteger.valueOf(1));
            dp.add(BigInteger.valueOf(1));
            dp.add(BigInteger.valueOf(1));
            dp.add(BigInteger.valueOf(2));
            dp.add(BigInteger.valueOf(2));

            for (int j = 6; j <= 100; j++) {
                dp.add(j, dp.get(j - 5).add(dp.get(j - 1)));
            }

            int n = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++) {
                bw.write(String.valueOf(dp.get(Integer.parseInt(br.readLine()))));
                bw.newLine();
            }
        }
    }
}