class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] arr_1 = new int[n][n];
        int[][] arr_2 = new int[n][n];
        for (int i = 0; i < arr1.length; i++) {
            int index = n - 1;
            while (arr1[i] > 0 && index >= 0) {
                arr_1[i][index--] = arr1[i] % 2;
                arr1[i] /= 2;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            int index = n - 1;
            while (arr2[i] > 0 && index >= 0) {
                arr_2[i][index--] = arr2[i] % 2;
                arr2[i] /= 2;
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if (arr_1[i][j] == 1 || arr_2[i][j] == 1) {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }
}