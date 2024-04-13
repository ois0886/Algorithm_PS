import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준알고리즘 13460번 구슬 탈출 2
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Marble {
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    Marble(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, M;
    static char[][] arr;
    static Point hole;
    static boolean[][][][] visit;
    static Marble blue, red;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if ('O' == str.charAt(j)) { // 구멍의 위치를 체크
                    hole = new Point(i, j);
                } else if (str.charAt(j) == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if (str.charAt(j) == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
                arr[i][j] = str.charAt(j);
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visit[red.rx][red.ry][blue.rx][blue.ry] = true;

        while (!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if (curCnt > 10) { // 이동 횟수가 10 초과시 실패
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 빨간 구슬 이동 -> # 벽을 만날 때까지 이동
                while (arr[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    // 이동 중 구멍을 만날 경우
                    if (newRx == hole.x && newRy == hole.y) {
                        isRedHole = true;
                        break;
                    }
                }

                // 파란 구슬 이동 -> # 벽을 만날 때까지 이동
                while (arr[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    // 이동 중 구멍을 만날 경우
                    if (newBx == hole.x && newBy == hole.y) {
                        isBlueHole = true;
                        break;
                    }
                }

                if (isBlueHole) { // 파란 구슬이 구멍에 빠지면 무조건 실패
                    continue; // 하지만 큐에 남은 다른 좌표도 봐야하니 다음으로
                }

                if (isRedHole && !isBlueHole) { // 빨간 구슬만 구멍에 빠지면 성공
                    return curCnt;
                }

                // 둘 다 구멍에 빠지지 않았는데 이동할 위치가 같은 경우 -> 위치 조정
                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) { // 위쪽으로 기울이기
                        // 더 큰 x값을 가지는 구슬이 뒤로 감
                        if (curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if (i == 1) { // 오른쪽으로 기울이기
                        // 더 작은 y값을 가지는 구슬이 뒤로 감
                        if (curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else if (i == 2) { // 아래쪽으로 기울이기
                        // 더 작은 x값을 가지는 구슬이 뒤로 감
                        if (curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else { // 왼쪽으로 기울이기
                        // 더 큰 y값을 가지는 구슬이 뒤로 감
                        if (curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                // 두 구슬이 이동할 위치가 처음 방문하는 곳인 경우만 이동 -> 큐에 추가
                if (!visit[newRx][newRy][newBx][newBy]) {
                    visit[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }
        return -1;
    }

}
