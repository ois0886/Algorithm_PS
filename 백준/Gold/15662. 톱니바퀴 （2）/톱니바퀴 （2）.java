import java.util.*;
import java.io.*;

class Main {
    static int t;
    static LinkedList[] ll;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        String s;
        t = Integer.parseInt(br.readLine());
        ll = new LinkedList[t + 1];

        for (int i = 1; i <= t; i++) {
            s = br.readLine();
            ll[i] = new LinkedList<Integer>();
            for (int j = 0; j < s.length(); j++)
                ll[i].add(s.charAt(j) - '0');
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            stz = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(stz.nextToken());
            int dir = Integer.parseInt(stz.nextToken());

            rotate(number, dir, 2);
        }

        System.out.println(count());
    }

    //right 값으로 왼쪽, 오른쪽, 양 옆(초기 값 2)으로 검사합니다.
    public static void rotate(int number, int clock, int right) {

        if (clock == 1)
            clock = -1;
        else
            clock = 1;

        //오른쪽으로 검사
        if (right == 1 || right == 2)
            if (diff(number, true)) {
                rotate(number + 1, clock, 1);
            }
        //왼쪽으로 검사
        if (right == 0 || right == 2)
            if (diff(number, false))
                rotate(number - 1, clock, 0);

        //시계방향 회전
        if (clock == -1)
            ll[number].addFirst(ll[number].removeLast());
            //반시계방향 회전
        else
            ll[number].addLast(ll[number].removeFirst());

    }

    public static boolean diff(int number, boolean right) {
        if (right) {
            if (number == t)
                return false;

            return ll[number].get(2) != ll[number + 1].get(6);
        } else {
            if (number == 1)
                return false;

            return ll[number].get(6) != ll[number - 1].get(2);
        }
    }

    public static int count() {
        int count = 0;

        for (int i = 1; i <= t; i++)
            if ((int) ll[i].get(0) == 1)
                count++;

        return count;
    }

}