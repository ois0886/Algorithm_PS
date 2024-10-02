import java.util.*;

public class Solution {
    public int[] solution(int[] answers) {
        // 수포자들의 찍는 패턴을 각각 배열로 정의
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 수포자들의 맞춘 문제 수를 저장할 배열
        int[] score = new int[3];

        // 각 문제에 대해 수포자들의 답과 비교하여 맞춘 문제를 카운팅
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) score[0]++;
            if (answers[i] == p2[i % p2.length]) score[1]++;
            if (answers[i] == p3[i % p3.length]) score[2]++;
        }

        // 세 수포자 중 가장 많이 맞춘 점수
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        // 가장 많이 맞춘 수포자(들)를 리스트로 저장
        List<Integer> result = new ArrayList<>();
        if (score[0] == maxScore) result.add(1);
        if (score[1] == maxScore) result.add(2);
        if (score[2] == maxScore) result.add(3);

        // 결과를 배열로 변환해 리턴

        int[] answer = result.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}