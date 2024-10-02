import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        //앞번호의 학생과 와 뒷번호의 학생 모두 여벌의 체육복이 있는 경우 
        // 앞번호의 학생으로부터 체육복을 빌림 
        // ????????????
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌을 챙겨온 사람이 도난당한 case: 
        // 체육복 다른사람에 빌려줄 수 없으며
        // answer에 해당 case만큼 추가한다
        // 더 가져온 내가 잃은 나에게...
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
            
            //lost배열과 reserve배열을 돌면서 두 값이 일치할 경우
            // 내가 나에게 빌려준 것으로 간주하고 answer++
            // 그리고 lost,reserve배열의 각 인덱스를 무의미한 값인 -1로 대입하여
            // 더이상 카운팅되지 않도록 처리
            // 그리고 해당 if문을 빠져나감(break)
                if(reserve[j]==lost[i]){
                    answer++;
                    lost[i] =-1;
                    reserve[j] =-1;
                    break;
                }
            }
        }
        
        // 여벌을 챙겨온 사람이 앞, 뒷번호에 체육복을 빌려주는 case:
        // 잃어버린 사람들 lost배열과 여벌을 챙긴 사람들 reserve배열을 이중for문으로 돌면서
        // reserve 배열의 인덱스 값 -1, 또는 +1이 lost배열의 인덱스 값과 일치하는 경우
        // 빌려줌 => answer++
        // 그리고 lost[i] 는 더 이상 빌릴 수 없고 reserve[i] 는 더이상 빌려줄 수 없으므로
        // 무의미한 값 -1 을 대입
        // 그리고 해당 반복문 탈출(break)
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(reserve[j]==lost[i]-1 || reserve[j]==lost[i]+1){
                    answer++;
                    lost[i]=-1;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        
        return answer;
    }
}