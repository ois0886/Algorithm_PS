import java.util.*;
import java.io.*;

class Main {
    static int H;
    static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] Harr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            Harr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < W - 1; i++) { //인덱스 별 모이는 빗물. 첫, 마지막 제외
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(Harr[j], left);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(Harr[j], right);
            }

            if (Harr[i] < left && Harr[i] < right) result += Math.min(left, right) - Harr[i];
        }
        System.out.println(result);

    }


}
