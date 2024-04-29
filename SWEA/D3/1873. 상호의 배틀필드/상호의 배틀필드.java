import java.io.*;
import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};// 위 아래 왼쪽 오른쪽
    static int[] dy = {0, 0, -1, 1};

    static int n, m;

    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];

            Tank tank = new Tank(0, 0, 0);

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] != '-' && map[i][j] != '.' || map[i][j] != '*' || map[i][j] != '#') {
                        if (map[i][j] == '^') { // 위
                            int dir = 0;
                            tank = new Tank(i, j, dir);
                        }
                        if (map[i][j] == 'v') { // 아래
                            int dir = 1;
                            tank = new Tank(i, j, dir);
                        }
                        if (map[i][j] == '<') { // 왼쪽
                            int dir = 2;
                            tank = new Tank(i, j, dir);
                        }
                        if (map[i][j] == '>') { // 오른쪽
                            int dir = 3;
                            tank = new Tank(i, j, dir);
                        }
                    }
                }
            }

            int orderN = Integer.parseInt(br.readLine());
            String orders = br.readLine();

            simulation(orderN, orders, tank);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

    private static void simulation(int orderN, String orders, Tank tank) {

        for (int i = 0; i < orderN; i++) {
            char order = orders.charAt(i);
            if (order == 'U') { // d위
                map[tank.x][tank.y] = '^';
                tank = new Tank(tank.x, tank.y, 0);
                int nx = tank.x + dx[tank.dir];
                int ny = tank.y + dy[tank.dir];
                if (range(nx, ny)) {
                    if (map[nx][ny] == '.') {
                        map[tank.x][tank.y] = '.';
                        map[nx][ny] = '^';
                        tank = new Tank(nx, ny, 0);
                    }
                }
            } else if (order == 'D') { // 아래
                map[tank.x][tank.y] = 'v';
                tank = new Tank(tank.x, tank.y, 1);
                int nx = tank.x + dx[tank.dir];
                int ny = tank.y + dy[tank.dir];
                if (range(nx, ny)) {
                    if (map[nx][ny] == '.') {
                        map[tank.x][tank.y] = '.';
                        map[nx][ny] = 'v';
                        tank = new Tank(nx, ny, 1);
                    }
                }
            } else if (order == 'L') { // 왼쪽
                map[tank.x][tank.y] = '<';
                tank = new Tank(tank.x, tank.y, 2);
                int nx = tank.x + dx[tank.dir];
                int ny = tank.y + dy[tank.dir];
                if (range(nx, ny)) {
                    if (map[nx][ny] == '.') {
                        map[tank.x][tank.y] = '.';
                        map[nx][ny] = '<';
                        tank = new Tank(nx, ny, 2);
                    }
                }
            } else if (order == 'R') { // 오른쪽
                map[tank.x][tank.y] = '>';
                tank = new Tank(tank.x, tank.y, 3);
                int nx = tank.x + dx[tank.dir];
                int ny = tank.y + dy[tank.dir];
                if (range(nx, ny)) {
                    if (map[nx][ny] == '.') {
                        map[tank.x][tank.y] = '.';
                        map[nx][ny] = '>';
                        tank = new Tank(nx, ny, 3);
                    }
                }
            } else if (order == 'S') { // 슛팅
                int curDir = tank.dir;
                int nx = tank.x + dx[curDir];
                int ny = tank.y + dy[curDir];
                while (range(nx, ny)) {
                    if (map[nx][ny] == '*') {
                        map[nx][ny] = '.';
                        break;
                    }
                    if (map[nx][ny] == '#') {
                        break;
                    }
                    nx = nx + dx[curDir];
                    ny = ny + dy[curDir];
                }
            }
        }
    }

    private static boolean range(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Tank {
    int x;
    int y;
    int dir;

    Tank(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}