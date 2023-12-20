import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Coordinate {
    int x;
    int y;


    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int m;
    static int n;

    static int[][] arr;
    static boolean[][] visit;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    number++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(number);
        System.out.println(max);
    }

    private static void DFS(int x, int y) {
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(x, y));
        int num = 1;
        visit[x][y] = true;
        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (range(nx, ny) && arr[nx][ny] == 1) {
                    if (!visit[nx][ny]) {
                        stack.push(new Coordinate(nx, ny));
                        visit[nx][ny] = true;
                        num++;
                    }
                }
            }
        }
        if (max < num) max = num;
    }

    private static boolean range(int x, int y) {
        return ((x < n) && (x >= 0)) && ((y < m) && (y >= 0));
    }

}