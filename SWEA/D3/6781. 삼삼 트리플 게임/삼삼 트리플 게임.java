import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int[][] a = new int[3][10];
            int set = 0;

            for (int i = 0; i < 9; i++) {
                char color = s2.charAt(i);
                int idx = s1.charAt(i) - '0';
                if (color == 'R')
                    a[0][idx]++;
                else if (color == 'B')
                    a[1][idx]++;
                else if (color == 'G')
                    a[2][idx]++;
            }

            for (int i = 0; i < 3; i++) {
                int[] cnt = new int[3];
                for (int j = 1; j < 10; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (a[k][j] > 0)
                            cnt[k]++;
                        else
                            cnt[k] = 0;
                        if (cnt[k] == 3) {
                            set++;
                            cnt[k] = 0;
                            for (int l = 0; l < 3; l++) {
                                a[k][j - l]--;
                            }
                        }
                    }
                }
                for (int j = 1; j < 10; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (a[k][j] > 2) {
                            set += a[k][j] / 3;
                            a[k][j] = a[k][j] % 3;
                        }
                    }
                }
            }
            if (set == 3)
                System.out.println("#" + t + " Win");
            else
                System.out.println("#" + t + " Continue");
        }
    }
}