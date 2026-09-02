import java.util.Arrays;

class Solution {

    String[][] tickets;
    String[] answer;
    int index;
    boolean flag;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.answer = new String[tickets.length + 1];
        this.index = 1;
        this.flag = false;

        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) {
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });

        answer[0] = "ICN";
        dfs(answer[0]);
        return answer;
    }

    private void dfs(String departure) {
        if (index == answer.length) {
            flag = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null && tickets[i][0].equals(departure)) {
                String[] next = tickets[i];
                tickets[i] = null; // 티켓 사용 완료
                answer[index] = next[1];
                index++;
                dfs(next[1]);
                if (flag) return;
                tickets[i] = next; // 티켓 사용 철회
                index--;
            }
        }
    }
}