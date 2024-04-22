import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("ZRO", 0);
        map1.put("ONE", 1);
        map1.put("TWO", 2);
        map1.put("THR", 3);
        map1.put("FOR", 4);
        map1.put("FIV", 5);
        map1.put("SIX", 6);
        map1.put("SVN", 7);
        map1.put("EGT", 8);
        map1.put("NIN", 9);

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(0, "ZRO");
        map2.put(1, "ONE");
        map2.put(2, "TWO");
        map2.put(3, "THR");
        map2.put(4, "FOR");
        map2.put(5, "FIV");
        map2.put(6, "SIX");
        map2.put(7, "SVN");
        map2.put(8, "EGT");
        map2.put(9, "NIN");

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            LinkedList<Integer> list = new LinkedList<>();
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[1]);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(map1.get(st.nextToken()));
            }
            Collections.sort(list);
            for (int i = 0; i < n; i++) {
                sb.append(map2.get(list.get(i))).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}