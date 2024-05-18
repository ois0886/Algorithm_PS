import java.util.*;

public class Solution {

    static int N;
    static int max;
    static int[] arr;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            max = -1; //-1 초기화
            N = sc.nextInt();
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int multi = arr[i] * arr[j];
                    increase(multi); //곱이 단조 증가가 맞는지 확인하여 max값 업데이트 할 함수
                }

            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static void increase(int num) {
        boolean up = true;
        String s = Integer.toString(num);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - '0' > (s.charAt(i + 1) - '0')) { //앞의 수가 더 크면 단조증가수 아님
                up = false;
                break;
            }
        }
        if (up) { //max update
            max = Math.max(num, max);
        }
    }
}