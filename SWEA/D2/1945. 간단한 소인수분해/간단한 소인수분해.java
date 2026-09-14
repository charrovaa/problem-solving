import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = sc.nextInt();
            int[] divisors = new int[]{2, 3, 5, 7, 11};
            int[] answer = new int[5];

            for (int i = 0; i < 5; i++) {
                int cnt = 0;
                while (num % divisors[i] == 0 && num != 1) {
                    num /= divisors[i];
                    cnt++;
                }
                answer[i] = cnt;
            }

            System.out.println("#" + test_case + " " + answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3] + " " + answer[4]);
        }

        sc.close();
	}
}