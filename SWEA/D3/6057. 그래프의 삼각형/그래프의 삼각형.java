import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int Test = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Test; i++) {
            String nm = bf.readLine();
            String[] nm_arr = nm.split(" ");

            int N = Integer.parseInt(nm_arr[0]);
            int M = Integer.parseInt(nm_arr[1]);

            boolean[][] check = new boolean[50][50];

            for (int j = 0; j < M; j++) {
                String xy = bf.readLine();
                String[] xy_arr = xy.split(" ");
                int x = Integer.parseInt(xy_arr[0]);
                int y = Integer.parseInt(xy_arr[1]);
                check[x - 1][y - 1] = true;
                check[y - 1][x - 1] = true;
            }

            int cnt = 0;

            for (int j = 0; j < 50; j++) {
                for (int q = j + 1; q < 50; q++) {
                    for (int k = q + 1; k < 50; k++) {
                        if (check[j][q] && check[q][k] && check[k][j]) {
                            cnt++;
                        }
                    }
                }
            }

            sb.append("#").append(i + 1).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}