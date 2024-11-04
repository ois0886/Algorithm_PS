import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int index = 1;
        String beforeWords = words[0];
        HashSet<String> set = new HashSet<>();
        set.add(beforeWords);
        for (int i = 1; i < words.length; i++) {
            index = i / n + 1;
            String cur = words[i];
            if (set.contains(cur) || cur.length() < 2 || beforeWords.charAt(beforeWords.length() - 1) != cur.charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = index;
                break;
            }
            set.add(cur);
            beforeWords = cur;
        }

        return answer;
    }
}