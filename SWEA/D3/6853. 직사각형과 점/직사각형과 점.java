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
            // ( X1, Y1 ), ( X1, Y2 ), ( X2, Y2 ), ( X2, Y1 )
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int inRec = 0;
            int middleRec = 0;
            int outRec = 0;


            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x1 < x && x < x2 && y1 < y && y < y2) inRec++;
                else if (x == x1 && y1 <= y && y <= y2) middleRec++;
                else if (x == x2 && y1 <= y && y <= y2) middleRec++;
                else if (y == y1 && x1 <= x && x <= x2) middleRec++;
                else if (y == y2 && x1 <= x && x <= x2) middleRec++;
                else outRec++;
            }
            sb.append(inRec).append(" ").append(middleRec).append(" ").append(outRec).append("\n");
        }
        System.out.println(sb);
    }
}