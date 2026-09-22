import java.math.BigInteger;

class Solution {

    public long solution(int n) {

        long answer = 0;
        int divisor = 1234567;
        BigInteger bDivisor = BigInteger.valueOf(divisor);

        for (int t = 0; t <= n / 2; t++) { // 2의 수
            int o = n - (t * 2); // 1의 수

            BigInteger two = BigInteger.valueOf(t);
            BigInteger one = BigInteger.valueOf(o);
            BigInteger oneTwo = BigInteger.valueOf(o + t);

            answer += factorial(oneTwo).divide(factorial(two)).divide(factorial(one)).mod(bDivisor).longValue();
            answer %= divisor;
        }

        return answer;
    }

    private BigInteger factorial(BigInteger value) {
        if (value.equals(BigInteger.ZERO)) return BigInteger.ONE;
        return value.multiply(factorial(value.subtract(BigInteger.ONE)));
    }
}