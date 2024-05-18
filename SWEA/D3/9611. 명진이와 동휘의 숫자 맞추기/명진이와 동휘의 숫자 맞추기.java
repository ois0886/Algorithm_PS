import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= test; t++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int[] answer = new int[10];
            Arrays.fill(answer, 1);

            for (int i = 0; i < query; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                String included = st.nextToken();
                if (included.equals("YES")) {
                    answer[a] *= 2;
                    answer[b] *= 2;
                    answer[c] *= 2;
                    answer[d] *= 2;
                }
                else {
                    answer[a] = answer[b] = answer[c] = answer[d] = 0;
                }
            }

            int index = 0;
            int max = -111;
            for (int i = 0; i < 10; i++) {
                if (answer[i] > max) {
                    max = answer[i];
                    index = i;
                }
            }
            System.out.println("#" + t + " " + index);
        }
    }
}