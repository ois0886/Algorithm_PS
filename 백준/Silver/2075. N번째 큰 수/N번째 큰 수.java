import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maxHeap.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i < N; i++){
            if(i == N - 1){
                System.out.println(maxHeap.poll());
            } else{
                maxHeap.poll();
            }
        }


    }
}

