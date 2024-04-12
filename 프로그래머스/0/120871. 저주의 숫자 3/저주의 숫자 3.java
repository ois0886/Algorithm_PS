class Solution {
    public int solution(int n) {
        int answer = 0;
 
        for (int i = 0; i < n; i++) {       //매개변수로 들어온 n까지 for문을 돌림
            answer++;                       //일단 answer에 1을 더하고 
            while (answer % 3 == 0 || String.valueOf(answer).contains("3")) { //3의 배수거나 "3"을 포함하고 있으면
                answer++;                   //answer를 그 다음 숫자로 넘어감
            }
        }
        return answer;
    }
}
