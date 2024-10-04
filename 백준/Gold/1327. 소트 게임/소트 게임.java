import java.util.*;
import java.io.*;

class Main {

    static int n, k;
    static int[] arr;

    // 배열을 오름차순으로 만들기 위한 최소 연산 횟수를 구하는 함수
    public static int bfs() {
        // 목표 상태: 1부터 n까지 오름차순 배열
        int[] goal = new int[n];
        for (int i = 0; i < n; i++) {
            goal[i] = i + 1;
        }

        // 큐와 방문 체크용 Set (배열을 문자열로 변환하여 상태 관리)
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 초기 상태를 큐에 넣고 방문 체크
        queue.offer(arr);
        visited.add(Arrays.toString(arr));

        int steps = 0;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 현재 레벨의 모든 상태를 처리
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                // 현재 상태가 목표 상태와 같으면 연산 횟수 반환
                if (Arrays.equals(current, goal)) {
                    return steps;
                }

                // K개의 연속된 부분을 뒤집는 모든 경우 탐색
                for (int j = 0; j <= n - k; j++) {
                    int[] next = current.clone();
                    reverse(next, j, j + k - 1);

                    // 새로 만들어진 배열을 문자열로 변환하여 방문 체크
                    String nextState = Arrays.toString(next);
                    if (!visited.contains(nextState)) {
                        queue.offer(next);
                        visited.add(nextState);
                    }
                }
            }
            steps++; // 모든 현재 레벨을 탐색 후, 연산 횟수 증가
        }

        return -1; // 목표 상태에 도달할 수 없을 경우 (이론상으로는 발생하지 않음)
    }

    // 배열의 start부터 end까지의 구간을 뒤집는 함수
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n 입력
        k = Integer.parseInt(st.nextToken()); // k 입력

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 입력
        }

        // BFS를 사용하여 최소 연산 횟수를 계산
        int result = bfs();
        System.out.println(result); // 결과 출력
    }
}