import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine().trim());
        }
        StringBuilder sb = new StringBuilder();
        int arrow = 0; // 화살표 현재 위치

        // 1단계: KBS1을 맨 위(0번)로 올리기
        int kbs1 = list.indexOf("KBS1");
        // 화살표를 KBS1까지 내리기 (버튼 1)
        while (arrow < kbs1) {
            sb.append('1');
            arrow++;
        }
        // KBS1을 위로 스왑 (버튼 4) → 0번까지
        while (arrow > 0) {
            Collections.swap(list, arrow, arrow - 1);
            sb.append('4');
            arrow--;
        }

        // 2단계: KBS2를 두 번째(1번)로 올리기
        int kbs2 = list.indexOf("KBS2");
        // 화살표를 KBS2까지 내리기 (버튼 1)
        while (arrow < kbs2) {
            sb.append('1');
            arrow++;
        }
        // KBS2를 위로 스왑 (버튼 4) → 1번까지
        while (arrow > 1) {
            Collections.swap(list, arrow, arrow - 1);
            sb.append('4');
            arrow--;
        }

        System.out.println(sb);
    }
}