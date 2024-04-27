
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 부먹 왕국의 도시 수
            int D = Integer.parseInt(st.nextToken()); // 이동 제한 거리

            int[] kingdom = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                kingdom[i] = Integer.parseInt(st.nextToken());

            int count = 0; // 이동거리 체크
            int fix = 0; // 설치할 차원관문 개수
            for (int i = 0; i < N; i++) {
                count++;

                if (kingdom[i] == 1 || count >= D) { // 차원관문이 있거나 최대 이동거리를 만족한 경우
                    if (count >= D && kingdom[i] != 1)
                        fix += 1;
                    count = 0;
                    continue;
                }
            }
            sb.append(fix).append("\n");
        }
        System.out.println(sb);
    }
}