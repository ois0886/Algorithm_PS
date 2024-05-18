import java.io.*;
import java.util.*;

public class Solution {
    static String result;
    static int sum;
    static void solve(String bits, int a, int b, int c, int d) {
        if( result != null ) return;
        if( b-c > 1 || c-b > 1 ) return;
        if( a<0 || b<0 || c<0 || d<0 ) return;
        if( a==0 && b==0 && c==0 && d==0 ) {
            result = bits;
            return;
        }
        if(bits.substring(bits.length()-1).equals("0")) {
            solve(bits+"0", a-1, b, c, d);
            solve(bits+"1", a, b-1, c, d);
            return;
        }
        solve(bits+"0", a, b, c-1, d);
        solve(bits+"1", a, b, c, d-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, tc;
        T = sc.nextInt();
        for(tc=1; tc<=T; tc++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();
            sum = A + B + C + D;
            result = null;
            solve("0", A, B, C, D);
            solve("1", A, B, C, D);
            if(result == null) result = "impossible";
            System.out.format("#%d %s\n", tc, result);
        }
        sc.close();
    }
}