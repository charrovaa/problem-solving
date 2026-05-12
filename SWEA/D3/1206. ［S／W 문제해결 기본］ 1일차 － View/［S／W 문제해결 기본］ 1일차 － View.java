import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int t = 1; t <= 10; t++) {
                int result = 0;
                int n = Integer.parseInt(br.readLine());

                int[] buildings = new int[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) buildings[i] = Integer.parseInt(st.nextToken());

                for (int i = 2; i < n - 2; i++) {
                    int max = Math.max(Math.max(buildings[i - 1], buildings[i - 2]), Math.max(buildings[i + 1], buildings[i + 2]));

                    if (max < buildings[i]) {
                        result += buildings[i] - max;
                    }
                }
                System.out.printf("#%d %d%n", t, result);
            }
        }
	}
}