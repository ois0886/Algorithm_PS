import java.util.*;
import java.io.*;

class Main {

    static int n, w, L;
    static Queue<Integer> truck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < w; i++){
            bridge.offer(0);
        }
        int time = 0;
        int bw = 0;
        while(!bridge.isEmpty()){
            time++;
            bw -= bridge.poll();
            if(!truck.isEmpty()){
                if(truck.peek() + bw <= L){
                    bw += truck.peek();
                    bridge.offer(truck.poll());
                } else{
                    bridge.offer(0);
                }
            }
        }
        System.out.println(time);

    }

}
