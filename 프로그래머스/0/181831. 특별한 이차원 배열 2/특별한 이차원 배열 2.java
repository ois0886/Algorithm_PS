class Solution {
    public int solution(int[][] arr) {
        boolean check = true;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] != arr[j][i]){
                    check = false;
                }
            }
        }
        if(check){
            return 1;
        }
        return 0;
    }
}