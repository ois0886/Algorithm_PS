import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }

        while (heap.size() >= 2 && heap.peek() < K) {
            int num1 = heap.poll();
            int num2 = heap.poll();
            int sco = num1 + (num2 * 2);
            heap.add(sco);
            answer++;
        }

        if (heap.peek() < K) {
            return -1;
        }

        return answer;
    }
}