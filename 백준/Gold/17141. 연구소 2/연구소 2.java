import java.io.*;
import java.util.*;

class Main {
    static class position {
        int x, y;

        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] laboratory;
    static position[] route;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayList<position> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        laboratory = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
                if (laboratory[i][j] == 2)
                    virus.add(new position(j, i));
            }
        }
        route = new position[M];
        search(0, 0);
        if (answer == Integer.MAX_VALUE)    
            bw.write("-1");
        else       
            bw.write(answer + "");
        bw.flush();       
        bw.close();
        br.close();
    }
    
    static void search(int count, int start) {
        if (count == M) {
            bfs();
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            route[count] = virus.get(i);
            search(count + 1, i + 1);
        }
    }
    
    static void bfs() {
        Queue<position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int result = 0;
        for (int i = 0; i < M; i++) {
            visited[route[i].y][route[i].x] = true;
            queue.add(route[i]);
        }
        while (!queue.isEmpty()) {
            if (result >= answer)
                return;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                position cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int tempX = cur.x + dx[j];
                    int tempY = cur.y + dy[j];
                    if (inLaboratory(tempX, tempY) && !visited[tempY][tempX]) {
                        if (laboratory[tempY][tempX] != 1) {
                            visited[tempY][tempX] = true;
                            queue.add(new position(tempX, tempY));
                        }
                    }
                }
            }
            result++;    
        }
        if (laboratoryCheck(visited))   
            answer = Math.min(answer, result - 1);
    }
    
    static boolean laboratoryCheck(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (laboratory[i][j] != 1 && !visited[i][j])
                    return false;
            }
        }
        return true;
    }
    
    static boolean inLaboratory(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}