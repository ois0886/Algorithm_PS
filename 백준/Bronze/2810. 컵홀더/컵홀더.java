import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int seat = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int holder = 0;

        // 모든 문자 사이 + 양끝에 * 삽입: SSS → *S*S*S*
        str = "*" + String.join("*", str.split("")) + "*";
        // 커플석 사이 컵홀더 제거: L*L → LL
        str = str.replace("L*L", "LL");

        // *의 개수 = 컵홀더 수
        for (char c : str.toCharArray()) {
            if (c == '*') holder++;
        }

        System.out.println(Math.min(seat, holder));

    }


}