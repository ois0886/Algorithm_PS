import java.util.*;
import java.io.*;

class Main {

    static int N, K;
    static int[] arr;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        System.out.println(simulation());

    }

    private static int simulation() {
        int cnt = 0;

        while (isOk()) {
            rotate();
            robotMove();
            battingRobot();
            cnt++;
        }

        return cnt;
    }

    private static void rotate(){
        int tmp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;

        for (int i = robot.length - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }

    private static void robotMove(){
        for (int i = robot.length - 1; i > 0; i--) {
            if (robot[i - 1] && !robot[i] && arr[i] >= 1) {
                arr[i]--;
                robot[i] = true;
                robot[i - 1] = false;
            }
        }
    }

    private static void battingRobot(){
        if (arr[0] > 0) {
            robot[0] = true;
            arr[0]--;
        }
    }

    private static boolean isOk() {
        int cnt = 0;
        for (int j : arr) {
            if (j == 0) {
                cnt++;
            }
            if (cnt >= K)
                return false;
        }
        return true;
    }

}