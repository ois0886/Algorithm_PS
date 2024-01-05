import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int ans = 0, cnt = 0;
            boolean p = false;
            String[] isNot = new String[N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                // 문자열이 회문이 아닌 경우 배열에 추가
                if (!isPalindrome(s)) {
                    isNot[i] = s;
                } else {
                    // 회문인 경우 플래그를 true로 설정
                    p = true;
                }
            }

            for (int i = 0; i < isNot.length; i++) {
                if (isNot[i] != null) {
                    String tmp = isNot[i];
                    for (int j = i + 1; j < isNot.length; j++) {
                        if (isNot[j] != null && tmp.equals(new StringBuilder(isNot[j]).reverse().toString())) {
                            cnt += 2;
                            isNot[j] = null;
                            break;
                        }
                    }
                }
            }

            ans = cnt * M;

            // 적어도 하나의 회문이 존재하는 경우 M을 더함
            if (p) {
                ans += M;
            }


            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
