import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if (!(Objects.equals(str, "Fizz") || Objects.equals(str, "Buzz") || Objects.equals(str, "FizzBuzz"))) {
                int num = Integer.parseInt(str) + (3 - i);
                if (num % 3 == 0) {
                    if (num % 5 == 0) {
                        System.out.println("FizzBuzz");
                    } else {
                        System.out.println("Fizz");
                    }
                } else if (num % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(num);
                }
                return;
            }
        }
    }
}