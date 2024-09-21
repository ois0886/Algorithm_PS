import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String S = br.readLine();
            String E = br.readLine();

            while (E.length() != S.length()) {
                if (E.charAt(E.length() - 1) == 'X') {
                    E = minusX(E);
                } else {
                    E = minusReversY(E);
                }
            }

            if (E.equals(S)) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static String minusX(String str) {
        return str.substring(0, str.length() - 1);
    }

    private static String minusReversY(String str) {
        StringBuilder target = new StringBuilder(str.substring(0, str.length() - 1));
        return target.reverse().toString();
    }
}