import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두 우선순위 큐는 내림차순 정렬.
        PriorityQueue<Integer> positiveQ = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>((p1, p2) -> p2 - p1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp > 0) {
                positiveQ.offer(temp);
            } else {
                negativeQ.offer(Math.abs(temp));
            }
        }

        // 가장 멀리 있는 책의 위치를 저장.
        int maxV = 0;
        if (positiveQ.isEmpty()) {
            maxV = negativeQ.peek();
        } else if (negativeQ.isEmpty()) {
            maxV = positiveQ.peek();
        } else {
            maxV = Math.max(positiveQ.peek(), negativeQ.peek());
        }

        int ans = 0;

        while (!positiveQ.isEmpty()) {
            int temp = positiveQ.poll();
            for (int i = 0; i < M - 1; i++) {
                positiveQ.poll();

                if (positiveQ.isEmpty()) {
                    break;
                }
            }
            ans += temp * 2;
        }

        while (!negativeQ.isEmpty()) {
            int temp = negativeQ.poll();
            for (int i = 0; i < M - 1; i++) {
                negativeQ.poll();

                if (negativeQ.isEmpty()) {
                    break;
                }
            }
            ans += temp * 2;
        }

        ans -= maxV;
        System.out.println(ans);

    }
}