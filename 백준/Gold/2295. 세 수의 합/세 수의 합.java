import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] u = new int[n];
        for(int i = 0; i < n; i++){
            u[i] = Integer.parseInt(br.readLine());
        }

        // 두개의 합 배열 만들기
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){// 중복을 최소화 하기 위해 j=i부터
                set.add(u[i] + u[j]);
            }
        }

        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int target = u[i] - u[j];// k는 u[i]이다.
                if(set.contains(target)){
                    max = Math.max(max, u[i]);
                }
            }
        }

        System.out.println(max);

    }
}