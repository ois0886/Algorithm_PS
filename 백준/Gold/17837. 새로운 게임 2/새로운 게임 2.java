
import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] map;
    static int n, k;
    static int cnt = 0;
    static Chess[] horse;
    static ArrayList<Integer>[][] list;
    static ArrayList<Integer> tmp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);
        horse = new Chess[k + 1];
        map = new int[n + 1][n + 1];

        list = new ArrayList[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
            String[] tt = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(tt[j - 1]);
            }
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            list[r][c].add(i);
            horse[i] = new Chess(r, c, dir);
        }

        solve();
    }

    public static void solve() {
        while (cnt <= 1000) {
            cnt++;
            move();
        }
        System.out.println(-1);
    }

    public static void move() {
        for (int i = 1; i <= k; i++) {
            Chess a = horse[i];
            int nx = a.x + dx[a.dir];
            int ny = a.y + dy[a.dir];
            if (!isRange(nx, ny) || map[nx][ny] == 2) {
                horse[i].dir = change_dir(a.dir);
                int tmp_x = horse[i].x + dx[horse[i].dir];
                int tmp_y = horse[i].y + dy[horse[i].dir];
                if (isRange(tmp_x, tmp_y) && map[tmp_x][tmp_y] != 2) {
                    remove(a.x, a.y, tmp_x, tmp_y, i, map[tmp_x][tmp_y] != 0);
                }

            } else if (isRange(nx, ny) && map[nx][ny] == 0) {
                remove(a.x, a.y, nx, ny, i, false);
            } else if (isRange(nx, ny) && map[nx][ny] == 1) {
                remove(a.x, a.y, nx, ny, i, true);
            }
            if (end()) {
                System.out.println(cnt);
                System.exit(0);
            }
        }
    }

    public static boolean end() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (list[i][j].size() >= 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void remove(int bx, int by, int nx, int ny, int num, boolean check) {
        int size = list[bx][by].size();
        boolean flag = true;
        tmp.clear();
        int idx = 0;
        for (int i = 0; i < size; i++) {
            if (list[bx][by].get(i) == num) {
                idx = i;
                flag = false;
            }
            if (!flag) {
                tmp.add(list[bx][by].get(i));
            }
        }

        if (check) {
            Collections.reverse(tmp);
        }

        if (size > idx) {
            list[bx][by].subList(idx, size).clear();
        }
        for (Integer integer : tmp) {
            horse[integer].x = nx;
            horse[integer].y = ny;
            list[nx][ny].add(integer);
        }

    }

    public static int change_dir(int dir) {
        switch(dir) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return 100000;
    }

    public static boolean isRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= n && y <= n;
    }
}

class Chess {
    int x, y, dir;

    Chess(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

