import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 분할 위치 1 ~ len-1
        for (int k = 1; k < str.length(); k++) {
            long front = 1, back = 1;
            for (int i = 0; i < k; i++)
                front *= (str.charAt(i) - '0');
            for (int i = k; i < str.length(); i++)
                back *= (str.charAt(i) - '0');
            if (front == back) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

}