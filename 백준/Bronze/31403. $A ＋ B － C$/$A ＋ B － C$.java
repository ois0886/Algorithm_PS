import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();


        int sum = Integer.parseInt(a + b);
        int result = sum - Integer.parseInt(c);

        System.out.println(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c));
        System.out.print(result);
    }
}