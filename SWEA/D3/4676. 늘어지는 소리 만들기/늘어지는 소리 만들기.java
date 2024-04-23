import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String str = br.readLine();
            int hypen_number = Integer.parseInt(br.readLine());
            int[] arr = new int[hypen_number];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < hypen_number; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.charAt(i));
            }
            for (int i = hypen_number - 1; i >= 0; i--) {
                list.add(arr[i], '-');
            }
            for (Character character : list) {
                sb.append(character);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}