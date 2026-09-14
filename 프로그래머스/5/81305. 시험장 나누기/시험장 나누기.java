class Solution {

    static int groupCnt = 0;

    public int solution(int k, int[] num, int[][] links) {

        int max = 0, min = Integer.MIN_VALUE, mid = 0, root = -1;
        boolean[] visited = new boolean[num.length];

        for (int[] link : links) {
            if (link[0] != -1) visited[link[0]] = true;
            if (link[1] != -1) visited[link[1]] = true;
        }

        // 루트 노드 연산
        for (int i = 0; i < visited.length; i++) if (!visited[i]) root = i;

        // 상한선, 하한선
        for (int i = 0; i < num.length; i++) {
            min = Math.max(min, num[i]);
            max += num[i];
        }

        mid = (max + min) / 2;

        // 이진 탐색
        while (min != max) {

            groupCnt = 0;
            grouping(mid, root, num, links);
            groupCnt++;

            if (groupCnt > k) { // 그룹이 더 많이 생긴 경우
                min = mid + 1;
            } else { // 그룹이 더 적거나 동일하게 생긴 경우
                max = mid;
            }

            mid = (min + max) / 2;
        }

        return min;
    }

    private int grouping(int mid, int nodeNum, int[] num, int[][] links){
        if (nodeNum == -1) return 0;

        int left = grouping(mid, links[nodeNum][0], num, links);
        int right = grouping(mid, links[nodeNum][1], num, links);

        // 리턴 값에 둘 다 합류 가능한 경우
        if (left + right + num[nodeNum] <= mid) {
            return left + right + num[nodeNum];
        }

        // 리턴 값에 둘 중 작은 값만 합류하는 경우
        int min = Math.min(left, right);

        if (min + num[nodeNum] <= mid) {
            groupCnt++; // 큰 값 집합 생성
            return num[nodeNum] + min;
        }

        // 둘 다 합류하지 못하는 경우
        groupCnt += 2;
        return num[nodeNum];
    }
}