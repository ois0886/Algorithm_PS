class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            if(check(i)) answer++;
        }
            
        return answer;
    }
    
    private static boolean check(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                sum += 1;
            }
        }

        return sum >= 3;
    }
}