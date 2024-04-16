import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        LinkedList<String> password;
        for (int t = 1; t <= 10; t++) {
            password = new LinkedList<>();
            br.readLine(); // 원본 암호문의 길이
            stk = new StringTokenizer(br.readLine(), " ");// 원본 암호문
            while (stk.hasMoreTokens()) {
                password.add(stk.nextToken());
            }

            br.readLine(); // 명령어의 개수
            stk = new StringTokenizer(br.readLine(), " "); // 명령어
            int x, y;
            while (stk.hasMoreTokens()) {
                stk.nextToken();
                x = Integer.parseInt(stk.nextToken());
                y = Integer.parseInt(stk.nextToken());
                for (int i = 0; i < y; i++) {
                    password.add(x++, stk.nextToken());
                }
            }

            System.out.print("#" + t);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + password.get(i));
            }
            System.out.println();
        }

    }

}