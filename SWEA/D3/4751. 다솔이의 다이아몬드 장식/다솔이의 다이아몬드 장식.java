import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 1; t <= test; t++) {
            String s = sc.next();
            int n = 3*(s.length()-1)+s.length()+4;
            char[][] a = new char[5][n];
            int k = 0;
            for(int i = 0; i < n; i ++) {
                if(i % 2 == 0) {
                    a[1][i] = '.';
                    a[3][i] = '.';
                }
                else {
                    a[1][i] = '#';
                    a[3][i] = '#';
                    a[2][i] = '.';
                }
                if((i-2)%4 == 0) {
                    a[0][i] = '#';
                    a[4][i] = '#';
                    a[2][i] = s.charAt(k);
                    k++;
                }
                else {
                    a[0][i] = '.';
                    a[4][i] = '.';
                }
                if(i % 4 == 0) {
                    a[2][i] = '#';
                }
            }

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
        }
    }
}