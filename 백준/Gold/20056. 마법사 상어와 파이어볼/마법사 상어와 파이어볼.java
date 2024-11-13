import java.util.*;
import java.io.*;

class Main {

    static int N, M, K;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


    static ArrayList<Fireball>[][] map;    //파이어볼 이동했을 때 정보
    static ArrayList<Fireball> fireballs = new ArrayList<>();    //모든 파이어볼 정보


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 행
            int c = Integer.parseInt(st.nextToken()); // 열
            int m = Integer.parseInt(st.nextToken()); // 질량
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 방향
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        /*
        모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
        이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
        이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
        같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
        파이어볼은 4개의 파이어볼로 나누어진다.
        나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
        질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
        속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
        합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
        질량이 0인 파이어볼은 소멸되어 없어진다.
         */

        //K번 이동명령 진행
        for (int i = 0; i < K; i++) {
            move(N);
            divide(N);
        }
        System.out.println(calculating());
    }

    //파이어볼 이동시키는 함수
    static void move(int N) {
        for (Fireball cur : fireballs) {
            //r, c값 변경
            // +N을 하는 이유는 이동하였을 때 음수가 나올 수 있기 때문입니다.
            int tempR = (cur.r + N + dx[cur.d] * (cur.s % N)) % N;
            int tempC = (cur.c + N + dy[cur.d] * (cur.s % N)) % N;
            cur.r = tempR;
            cur.c = tempC;
            //이동한 파이어볼 저장
            map[cur.r][cur.c].add(cur);
        }
    }

    //파이어볼 분열 진행
    static void divide(int N) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                //파이어볼 개수가 2개 미만일 때
                if (map[r][c].size() < 2) {
                    map[r][c].clear();
                    continue;
                }
                //파이어볼 2개 이상일 때
                int mSum = 0, sSum = 0, oddCount = 0, evenCount = 0;
                int size = map[r][c].size();
                //분열 진행!
                for (Fireball cur : map[r][c]) {
                    mSum += cur.m;    //질량 더하기
                    sSum += cur.s;    //속도 더하기
                    if (cur.d % 2 == 1)    //방향 홀수일 때
                        oddCount++;
                    else        //방향 짝수일 때
                        evenCount++;
                    fireballs.remove(cur);    //분열될 파이어볼 제거!
                }
                map[r][c].clear();
                mSum /= 5;    //분열될 질량 구하기
                if (mSum == 0)    //분열될 질량이 0이면 분열 실패!
                    continue;
                sSum /= size;    //분열될 속도 구하기
                //모든 파이어볼 방향이 짝수이거나 홀수일 때
                if (oddCount == size || evenCount == size) {
                    for (int i = 0; i < 8; i += 2)    //{0, 2, 4, 6} 방향 분열
                        fireballs.add(new Fireball(r, c, mSum, sSum, i));
                } else {
                    for (int i = 1; i < 8; i += 2)    //{1, 3, 5, 7} 방향 분열
                        fireballs.add(new Fireball(r, c, mSum, sSum, i));
                }
            }
        }
    }

    //파이어볼 질량의 합 구하는 함수
    static int calculating() {
        int result = 0;
        //모든 질량 더하기!
        for (Fireball cur : fireballs)
            result += cur.m;
        return result;
    }
}


class Fireball {
    int r;
    int c;
    int m;
    int s;
    int d;

    Fireball(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}