import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int result = -1;

           for(int i = N - 1; i >= 0; i--){
               for(int j = i - 1; j >= 0; j--){
                   if(i != j && M >= arr[i] + arr[j]){
                       result = Math.max(result, arr[i]+arr[j]);
                   }
               }
           }
           sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}