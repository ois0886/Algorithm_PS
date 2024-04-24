import java.io.*;
import java.util.*;

class Solution {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        isPrime = new boolean[1000001];
        isPrime_fun();
        for(int i = 2; i <= 1000000; i++){
            if(isPrime[i]){
                sb.append(i).append(" ");
            }
        }
        sb.append("\n");
        System.out.println(sb);
    }
    static void isPrime_fun(){
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니니깐 false

        for(int i = 2; i <= Math.sqrt(1000000); i++){ // 2부터 n의 제곱근까지의 모든 수를 확인
            if(isPrime[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j<= 1000000; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
                }
            }
        }
    }
}