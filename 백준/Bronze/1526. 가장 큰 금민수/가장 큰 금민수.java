import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            if (checking(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean checking(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit != 4 && digit != 7) return false;
            n /= 10;
        }
        return true;
    }

}