import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] stop = {'.', '?', '!'};

        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int cnt = 0;
            int[] a = new int[n];

            while (cnt != n) {
                String s = sc.next();
                if (65 <= s.charAt(0) && s.charAt(0) <= 90) {
                    int flag = 0;
                    int last = s.length() - 1;
                    if (s.charAt(last) == 46 || s.charAt(last) == 33 || s.charAt(last) == 63)
                        last--;
                    for (int i = 1; i <= last; i++) {
                        if (s.charAt(i) < 97 || s.charAt(i) > 122) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0)
                        a[cnt]++;
                }
                for (int i = 0; i < 3; i++) {
                    if (s.charAt(s.length() - 1) == stop[i]) {
                        cnt++;
                        break;
                    }
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}