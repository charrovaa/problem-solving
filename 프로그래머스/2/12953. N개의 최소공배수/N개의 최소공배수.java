class Solution {
    public int solution(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = lcm(ans, arr[i]);
        }
        return ans;
    }

    private int lcm(int a, int b) { // 최소공배수 : gcd 활용
        int gcd = gcd(Math.max(a, b), Math.min(a, b));
        return a * b / gcd;
    }

    private int gcd(int a, int b) { // 최대공약수 (큰 값, 작은 값) : 유클리드 호제법
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}