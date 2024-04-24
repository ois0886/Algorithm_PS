import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            String[] start = br.readLine().split(":");
            String[] end = br.readLine().split(":");

            int startSecond = 0;
            int endSecond = 0;

            startSecond += Integer.parseInt(start[2]);
            startSecond += (Integer.parseInt(start[1]) * 60);
            startSecond += (Integer.parseInt(start[0]) * 60 * 60);

            endSecond += Integer.parseInt(end[2]);
            endSecond += (Integer.parseInt(end[1]) * 60);
            endSecond += (Integer.parseInt(end[0]) * 60 * 60);

            int Second = endSecond - startSecond;

            
            if(Second < 0){
                Second += 86400;
            }



            String result = "";
            int resultS = Second % 60;
            Second /= 60;
            int resultM = Second % 60;
            Second /= 60;
            int resultH = Second;

            if (resultH < 10) {
                result += "0";
            }
            result += String.valueOf(resultH);
            result += ":";

            if (resultM < 10) {
                result += "0";
            }
            result += String.valueOf(resultM);
            result += ":";

            if (resultS < 10) {
                result += "0";
            }
            result += String.valueOf(resultS);

            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }
}