class Solution {
    public int[] solution(int brown, int yellow) {

        int smaller = 0;
        int larger = 0;

        int sqrt = (int) Math.sqrt(yellow);
        for (int i = 1; i <= sqrt; i++) {
            if (yellow % i == 0) {
                smaller = i;
                larger = yellow / i;
                int border = ((smaller + 1) + (larger + 1)) * 2;
                if (border == brown) break;
            }
        }

        return new int[] {larger + 2, smaller + 2};
    }
}