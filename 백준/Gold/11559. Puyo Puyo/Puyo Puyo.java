import java.util.*;
import java.io.*;

public class Main {

    static char[][] map = new char[12][6];

    static int pop = 0;
    static boolean isPop = false;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        while (true) {
            isPop = false;

            bfs();
            onFloor();


            if (!isPop) {
                break;
            }
            pop++;
        }

        System.out.println(pop);
    }

    static void bfs() {
        Queue<Puyo> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.' && !isVisited[i][j]) {
                    ArrayList<int[]> list = new ArrayList<>();

                    que.add(new Puyo(i, j, map[i][j]));
                    list.add(new int[]{i, j});
                    isVisited[i][j] = true;

                    while (!que.isEmpty()) {
                        Puyo p = que.poll();

                        int curX = p.x;
                        int curY = p.y;
                        char curColor = p.color;

                        for (int t = 0; t < 4; t++) {
                            int nx = curX + dx[t];
                            int ny = curY + dy[t];

                            if (range(nx, ny)) continue;

                            if (!isVisited[nx][ny] && map[nx][ny] == curColor) {
                                que.add(new Puyo(nx, ny, map[nx][ny]));
                                list.add(new int[]{nx, ny});
                                isVisited[nx][ny] = true;
                            }
                        }

                    }

                    if (list.size() >= 4) {
                        for (int[] ints : list) {
                            int x = ints[0];
                            int y = ints[1];

                            map[x][y] = '.';
                            isPop = true;
                        }
                    }

                }
            }
        }
    }

    private static boolean range(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= 12 || ny >= 6;
    }

    // 모든 뿌요를 바닥까지 내림
    static void onFloor() {
        for (int j = 0; j < 6; j++) {
            down(j);
        }
    }

    // 한 열에 있는 뿌요를 바닥까지 내림
    static void down(int j) {
        Queue<Puyo> puyo = new LinkedList<>();
        int idx = 11;

        for (int i = 11; i >= 0; i--) {
            if (map[i][j] != '.') {
                puyo.add(new Puyo(i, j, map[i][j]));
                map[i][j] = '.';
            }
        }

        while (!puyo.isEmpty()) {
            Puyo p = puyo.poll();
            char color = p.color;
            map[idx][j] = color;
            idx--;
        }

    }

    static class Puyo {
        int x, y;
        char color;

        Puyo(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

}