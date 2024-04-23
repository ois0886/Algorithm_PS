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
            int[] arr = new int[7];
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 7; j++) {
                    for (int z = j + 1; z < 7; z++) {
                        set.add(arr[i] + arr[j] + arr[z]);
                    }
                }
            }

            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            sb.append(list.get(list.size() - 5)).append("\n");
        }
        System.out.println(sb);
    }
}