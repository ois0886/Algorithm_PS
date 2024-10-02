
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        // 정규 표현식 패턴: 숫자 (\d+), 문자 ([A-Za-z]), 특수 문자 ([#*])
        Pattern pattern = Pattern.compile("\\d+|[A-Za-z]|[#*]");
        Matcher matcher = pattern.matcher(dartResult);

        List<String> result = new ArrayList<>();

        // 정규 표현식 매칭 결과를 하나씩 리스트에 추가
        while (matcher.find()) {
            result.add(matcher.group());
        }

        Stack<Integer> number = new Stack<>();
        Stack<Integer> cal_number = new Stack<>();

        for (int i = 0; i < result.size(); i++) {
            if (Objects.equals(result.get(i), "S")) { // single
                int num = number.pop();
                cal_number.push(num);
            } else if (Objects.equals(result.get(i), "D")) { // double
                int num = number.pop();
                cal_number.push(num * num);
            } else if (Objects.equals(result.get(i), "T")) { // trifle
                int num = number.pop();
                cal_number.push(num * num * num);
            } else if (Objects.equals(result.get(i), "#")) { // 아차상
                int num = cal_number.pop();
                num *= -1;
                cal_number.push(num);
            } else if (Objects.equals(result.get(i), "*")) { // 스타상
                if (cal_number.size() < 2) {
                    int num = cal_number.pop() * 2;
                    cal_number.push(num);
                } else {
                    int first_num = cal_number.pop();
                    int second_num = cal_number.pop();
                    first_num *= 2;
                    second_num *= 2;
                    cal_number.push(second_num);
                    cal_number.push(first_num);
                }
            } else {
                number.push(Integer.parseInt(String.valueOf(result.get(i))));
            }
        }

        while (!cal_number.isEmpty()) {
            int num = cal_number.pop();
            answer += num;
        }

        return answer;
    }
}