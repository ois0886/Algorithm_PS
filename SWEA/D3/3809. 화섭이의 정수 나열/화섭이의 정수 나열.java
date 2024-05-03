import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for(int tc=1; tc<=t; tc++) {
            int N = scan.nextInt();
            StringBuilder str = new StringBuilder();

            // 입력받은 숫자를 문자열로 붙여서 만들기.
            for(int i=0; i<N; i++) {
                str.append(Integer.toString(scan.nextInt()));
            }

            // i의 값을 String으로 변환후, 위에서 이어붙인 str에 포함되지 않을경우 -> 가장 작은 정수
            for(int i=0; ; i++) {
                if(!str.toString().contains(Integer.toString(i))) {
                    System.out.println("#" + tc + " " + i);
                    break;
                }
            }
        }
        scan.close();
    }

}