import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Test; i++) {
            int N = Integer.parseInt(bf.readLine());

            ArrayList<Integer> list = new ArrayList<>();

            // N보다 작은 소수 구하기
            for (int j = 1 ; j <= N ; j++){
                int cnt = 0;
                for (int q = 1 ; q <= j ; q++){
                    if (j%q == 0)
                        cnt++;
                }

                if (cnt == 2)
                    list.add(j);
            }

            Collections.sort(list);

            int cnt = 0;

            for (int j = 0 ; j < list.size() ; j++){
                for (int q = j ; q < list.size() ; q++){
                    for (int k = q ; k < list.size() ; k++){
                        if ((list.get(j) + list.get(q) + list.get(k)) == N)
                            cnt++;
                    }
                }
            }

            sb.append("#").append(i+1).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}