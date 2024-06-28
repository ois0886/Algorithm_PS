class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            String[] str = quiz[i].split(" ");
            int x = Integer.parseInt(str[0]);
            String operator = str[1];
            int y = Integer.parseInt(str[2]);
            int z = Integer.parseInt(str[4]);
            int result = 0;
            switch (operator) {
                case "+":
                    result = x + y;
                    break;

                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                case "/":
                    result = x / y;
                    break;
                default:
                    break;
            }
            if (result == z) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }

        }
        return answer;
    }
}