import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
            int result = 0;
            int number = Integer.parseInt(sc.nextLine());
            int[] buildings = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 2; i < number - 2; i++) {
                int max = Math.max(Math.max(buildings[i - 1], buildings[i - 2]), Math.max(buildings[i + 1], buildings[i + 2]));

                if (max < buildings[i]) {
                    result += buildings[i] - max;
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
		}
        sc.close();
	}
}