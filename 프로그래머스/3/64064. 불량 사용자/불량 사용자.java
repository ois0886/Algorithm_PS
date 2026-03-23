import java.util.*;

class Solution {
    private Set<Set<String>> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        // 각 banned_id에 매칭되는 user_id 후보 목록 구성
        List<List<String>> candidates = new ArrayList<>();
        for (String banned : banned_id) {
            List<String> matched = new ArrayList<>();
            for (String user : user_id) {
                if (matches(user, banned)) matched.add(user);
            }
            candidates.add(matched);
        }

        dfs(candidates, 0, new HashSet<>());
        return resultSet.size();
    }

    private void dfs(List<List<String>> candidates, int idx, Set<String> chosen) {
        if (idx == candidates.size()) {
            resultSet.add(new HashSet<>(chosen)); // 순서 무관 → Set으로 저장
            return;
        }
        for (String user : candidates.get(idx)) {
            if (!chosen.contains(user)) {
                chosen.add(user);
                dfs(candidates, idx + 1, chosen);
                chosen.remove(user);
            }
        }
    }

    // userId가 bannedId 패턴과 일치하는지 확인
    private boolean matches(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) return false;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}