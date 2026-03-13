import java.util.*;

class Solution {
    boolean[] used;     // 티켓 사용 여부
    List<String> route; // 현재 경로
    String[] answer;

    public String[] solution(String[][] tickets) {
        // 알파벳 순으로 정렬 → 먼저 찾은 경로가 정답
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        used = new boolean[tickets.length];
        route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN", tickets);

        return answer;
    }

    private boolean dfs(String cur, String[][] tickets) {
        // 모든 티켓을 다 썼으면 완성
        if (route.size() == tickets.length + 1) {
            answer = route.toArray(new String[0]);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (used[i]) continue;              // 이미 쓴 티켓
            if (!tickets[i][0].equals(cur)) continue; // 출발지 불일치

            used[i] = true;
            route.add(tickets[i][1]);

            if (dfs(tickets[i][1], tickets)) return true; // 찾으면 끝

            // 백트래킹: 이 경로로는 전부 소모 불가
            used[i] = false;
            route.remove(route.size() - 1);
        }

        return false;
    }
}
