import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N, M, R;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve() {
        for (int i = 0; i < R; i++) {
            // 가장 큰 사각형부터 안으로 한 번씩 돌리기
            for (int j = 0; j < Math.min(N, M) / 2; j++) {

                int temp = map[j][j];  //각 사각형의 왼쪽 위 값 저장

                // left
                for (int k = j; k < M - j - 1; k++) {
                    map[j][k] = map[j][k + 1];
                }
                // up
                for (int k = j; k < N - 1 - j; k++) {
                    map[k][M - j - 1] = map[k + 1][M - j - 1];
                }
                // right
                for (int k = M - j - 1; k > j; k--) {
                    map[N - 1 - j][k] = map[N - 1 - j][k - 1];
                }
                // down
                for (int k = N - j - 1; k > j; k--) {
                    map[k][j] = map[k - 1][j];
                }
                map[j + 1][j] = temp;
            }
        }
    }

}
