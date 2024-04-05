import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int n = Integer.parseInt(br.readLine());
            char[][] graph = new char[n][n];
            for (int i = 0; i < n; i++) {
                graph[i] = br.readLine().toCharArray();
            }

            int charpCnt = 0, posRow = 0, posCol = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (graph[row][col] == '#') {
                        charpCnt++;
                        if (charpCnt == 1) {
                            posRow = row;
                            posCol = col;
                        }
                    }
                }
            }

            int side = 0, total = 0;
            for (int i = posCol; i < n; i++) {
                if (graph[posRow][i] == '#') {
                    side++;
                    total++;
                } else {
                    break;
                }
            }

            boolean flg = false;
            int sideRow = 1;
            for (int j = posRow + 1; j < n; j++) {
                int cnt = 0;
                sideRow++;
                if (sideRow > side) {
                    break;
                }
                for (int i = posCol; i < n; i++) {
                    if (graph[j][i] == '#') {
                        cnt++;
                        total++;
                    } else {
                        break;
                    }
                }
                if (cnt != side) {
                    flg = true;
                    break;
                }
            }
            if (total == charpCnt && !flg) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}