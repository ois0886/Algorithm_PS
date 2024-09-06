import java.util.*;
 
public class Main {
    
    static int n;
    static int[][] board;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static boolean[][] visited;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
            }
        }
 
        visited = new boolean[n][n];
        bfs();
    }
 
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[] {0, 0});
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int count = board[current[0]][current[1]];
 
            if(count == -1) {
                System.out.println("HaruHaru");
                return;
            }
 
            for(int i = 0; i < 2; i++) {
                int nx = current[0] + dx[i] * count;
                int ny = current[1] + dy[i] * count;
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
    
            }
        }
        System.out.println("Hing");
    }
}