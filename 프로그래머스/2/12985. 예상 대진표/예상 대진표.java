class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 1;

        for (int i = n; i > 0; i /= 2) {
            if (opponent(a) == b) break;
            a = nextNum(a);
            b = nextNum(b);
            cnt++;
        }

        return cnt;
    }

    private int opponent(int num) {
        if (num % 2 == 0) return num - 1;
        return num + 1;
    }

    private int nextNum(int num) {
        if (num % 2 == 0) return num / 2;
        return num / 2 + 1;
    }
}