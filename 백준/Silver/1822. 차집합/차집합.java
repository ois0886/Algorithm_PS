import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static HashSet<Integer> a;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            a.remove(num);
        }
        // HashSet을 int[]로 변환
        int[] array = new int[a.size()];  // HashSet 크기만큼의 배열 생성
        int index = 0;
        for (int num : a) {
            array[index++] = num;  // HashSet의 각 요소를 배열에 추가
        }
        Arrays.sort(array);
        // 배열 출력
        System.out.println(array.length);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}