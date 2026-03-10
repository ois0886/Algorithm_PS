import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        // 수열 생성하며 각 수의 첫 등장 인덱스 기록
        Map<Integer, Integer> map = new HashMap<>();
        int num = N;
        int idx = 0;
        while (true) {
            num = (num * N) % P;
            if (map.containsKey(num)) {
                // 사이클 길이 = 현재 인덱스 - 처음 등장 인덱스
                System.out.println(idx - map.get(num));
                break;
            }
            map.put(num, idx);
            idx++;
        }

    }
}