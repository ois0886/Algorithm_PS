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
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Lottery[] lotto = new Lottery[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String number = st.nextToken();
                int cash = Integer.parseInt(st.nextToken());
                lotto[i] = new Lottery(number, cash);
            }

            long result = 0;

            for (int i = 0; i < m; i++) {
                String myLotteryNumber = br.readLine();
                for(int j = 0; j < n; j++){
                    boolean check = true;
                    for(int z = 0; z < lotto[j].number.length(); z++){
                        if(lotto[j].number.charAt(z) == '*') continue;
                        if (lotto[j].number.charAt(z) != myLotteryNumber.charAt(z)) {
                            check = false;
                            break;
                        }
                    }
                    if(check) result += lotto[j].cash;
                }
            }

            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
}

class Lottery {
    String number;
    int cash;

    Lottery(String number, int cash) {
        this.number = number;
        this.cash = cash;
    }
}