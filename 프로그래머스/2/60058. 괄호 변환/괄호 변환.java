class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        // 2. u, v 분리 — u는 더 이상 분리할 수 없는 균형잡힌 괄호 문자열
        int count = 0;
        int splitIdx = 0;
        for (int i = 0; i < p.length(); i++) {
            count += p.charAt(i) == '(' ? 1 : -1;
            if (count == 0) {
                splitIdx = i;
                break;
            }
        }

        String u = p.substring(0, splitIdx + 1);
        String v = p.substring(splitIdx + 1);

        // 3. u가 올바른 괄호 문자열이면
        if (isCorrect(u)) {
            return u + solution(v);
        }

        // 4. u가 올바른 괄호 문자열이 아니면
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(solution(v));
        sb.append(')');
        for (int i = 1; i < u.length() - 1; i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }
        return sb.toString();
    }

    private boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == '(' ? 1 : -1;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
