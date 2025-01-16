import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] strs = new String[4];
        for (int i = 0; i < 4; i++) {
            strs[i] = st.nextToken();
        }
        String A = strs[0];
        String B = strs[1];
        String C = strs[2];
        String D = strs[3];

        String AB = A + B;
        String CD = C + D;
        System.out.println(Long.parseLong(AB) + Long.parseLong(CD));

    }
}