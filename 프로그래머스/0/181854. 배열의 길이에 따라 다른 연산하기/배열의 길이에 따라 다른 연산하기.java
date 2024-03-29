import java.util.*;

class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];
        if(arr.length % 2 == 0){ // 짝수
            for(int i = 0 ; i < arr.length; i++){
                if(i % 2 == 1){
                    answer[i] = arr[i] + n;
                } else{
                    answer[i] = arr[i];
                }
            }
            
        } else{ // 홀수
            for(int i = 0 ; i < arr.length; i++){
                if(i % 2 == 0){
                    answer[i] = arr[i] + n;
                } else{
                    answer[i] = arr[i];
                }
            }
        }
    
        return answer;
    }
}