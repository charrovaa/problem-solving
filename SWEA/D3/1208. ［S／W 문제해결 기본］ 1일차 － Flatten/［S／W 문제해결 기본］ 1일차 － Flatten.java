import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int cnt = sc.nextInt();

            List<Integer> nums = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                nums.add(sc.nextInt());
            }

            Collections.sort(nums); // 오름차순

            for (int i = 0; i < cnt; i++) {
                nums.set(0, nums.get(0) + 1);
                nums.set(99, nums.get(99) - 1);
                Collections.sort(nums);
            }

            int answer = nums.get(99) - nums.get(0);

            System.out.println("#" + test_case + " " + answer);
		}

        sc.close();
	}
}