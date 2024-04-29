import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());

            int[][] telephonePoles = new int[N][2]; // 전봇대 위치 저장 배열

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                telephonePoles[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
                telephonePoles[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
            }

            int cnt = 0; // 교차하는 전봇대 쌍의 수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue; // 같은 전봇대는 비교하지 않음

                    if (telephonePoles[i][0] < telephonePoles[j][0] && telephonePoles[i][1] > telephonePoles[j][1]) {
                        cnt++;
                    } else if (telephonePoles[i][0] > telephonePoles[j][0] && telephonePoles[i][1] < telephonePoles[j][1]) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt/2).append("\n");

        }
        System.out.println(sb);
    }
}