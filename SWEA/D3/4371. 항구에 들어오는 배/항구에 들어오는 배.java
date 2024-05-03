import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            int N = Integer.parseInt(br.readLine());
            boolean [] check = new boolean[N];
            int[] harbor = new int[N];

            for (int i = 0; i < N; ++i) {
                harbor[i] = Integer.parseInt(br.readLine());
            }

            int boatCnt = 0;
            for (int i = 1; i < N; ++i) {
                if (check[i]) {
                    continue;
                }

                boatCnt++;

                int cycle = harbor[i] - 1;
                int happyDay = harbor[i];
                for (int j = i; j < N; ++j) {
                    if (happyDay == harbor[j]) {
                        check[j] = true;
                        happyDay += cycle;
                    }
                }
            }
            sb.append(boatCnt).append("\n");
        }
        System.out.println(sb);
    }
}