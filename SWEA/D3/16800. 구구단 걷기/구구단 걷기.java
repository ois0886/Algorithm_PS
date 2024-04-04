import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            long N = Long.parseLong(br.readLine());
            long path = N - 1; // 경로 path를 선언하고 최장거리로 초기화함
            for (long num = 2; num <= Math.sqrt(N); num++) { // N을 두 수(i와 j)로 인수분해가 되는 형태를 찾음
                if (N % num == 0) { // 나누어떨어진다면 N의 약수를 하나 찾은 것이고
                    if (path > (num + (N / num) - 2)) { // 찾은 (i,j) 셀로의 경로 (i-1)+(j-1)과 기존경로를 비교하여 더 짧다면 갱신함
                        path = (num + (N / num) - 2);
                    }
                }
            }

            sb.append(path).append("\n");
        }
        System.out.println(sb);
    }
}