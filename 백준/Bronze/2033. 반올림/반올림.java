import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        long unit = 10;
        while (n > unit) {
            long digit = (n % unit) / (unit / 10); // 반올림할 자릿수
            if (digit >= 5) {
                n = (n / unit + 1) * unit;  // 올림
            } else {
                n = (n / unit) * unit;      // 버림
            }
            unit *= 10;
        }
        System.out.println(n);
    }
}