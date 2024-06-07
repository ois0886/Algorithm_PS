class Solution {
    fun solution(number: IntArray): Int {            

        var answer: Int = 0

        for(i in 0 until number.size) {
            for(j in i+1 until number.size step 1) {
                for(k in j+1 until number.size step 1) {
                    if (number[i] + number[j] + number[k] === 0) {
                        answer++;
                    }
                }
            }
        }

        return answer
    }
}