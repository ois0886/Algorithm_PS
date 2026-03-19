import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        // [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
        /*
         -> 이걸 일단 정렬
         [-20,-15], [-18,-13], [-14,-5], [-5,-3]
         */
        int camera = routes[0][1];
        int answer = 1;
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > camera) {
                camera = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}