import java.util.*;
import java.io.*;

class Main {

    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        while (que.size() > 1) {
            // 제일 위에 있는 카드를 버림
            int num1 = que.poll();
            sb.append(num1).append(" ");

            // 제일 위에 있는 카드를 맨 뒤로
            int num2 = que.poll();
            que.offer(num2);
        }

        sb.append(que.poll());

        System.out.println(sb);
    }
}