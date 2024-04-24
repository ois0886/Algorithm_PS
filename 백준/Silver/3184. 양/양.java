import java.util.*;
import java.io.*;

class Main {
    static int N, M;

    static String[][] map;

    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }
        int ship = 0;
        int wolfe = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && !Objects.equals(map[i][j], "#")) {
                    int[] result = BFS(i, j);
                    ship += result[0];
                    wolfe += result[1];
                }
            }
        }

        System.out.println(ship + " " + wolfe);
    }

    private static int[] BFS(int x, int y) {
        visited[x][y] = true;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});

        int ship = 0;
        int wolfe = 0;

        if(Objects.equals(map[x][y], "v")){
            wolfe++;
        }
        if(Objects.equals(map[x][y], "o")){
            ship++;
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(range(nx,ny) && !visited[nx][ny] && !Objects.equals(map[nx][ny], "#")){
                    if(Objects.equals(map[nx][ny], "v")){
                        wolfe++;
                    }
                    if(Objects.equals(map[nx][ny], "o")){
                        ship++;
                    }
                    visited[nx][ny] = true;
                    que.offer(new int[]{nx, ny});
                }
            }
        }
        if(ship > wolfe){
            return new int[]{ship, 0};
        }

        return new int[]{0, wolfe};
    }

    private static boolean range(int x, int y){
        return 0 <= x && x < N && 0 <= y  && y < M;
    }


}