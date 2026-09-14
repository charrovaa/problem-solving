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
            if (num % 2 == 0) {
                num = (num / 2) * -1;
            } else {
                num = (num / 2) * -1 + num;
            }
            System.out.println("#" + test_case + " " + num);
        }
        sc.close();
	}
}