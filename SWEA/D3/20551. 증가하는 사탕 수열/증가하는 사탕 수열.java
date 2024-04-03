import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int[] arr = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            while (true) {

                if (arr[1] >= arr[2] && arr[1] > 1) {
                    answer++;
                    arr[1]--;
                }

                if (arr[0] >= arr[1] && arr[0] > 1) {
                    answer++;
                    arr[0]--;
                }

                if(arr[2] == 1 || arr[2] == 2){
                    answer = -1;
                    break;
                }

                if(arr[0] == 1 && arr[1] == 1){
                    answer = -1;
                    break;
                }

                if (arr[0] < arr[1] && arr[1] < arr[2]) break;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}