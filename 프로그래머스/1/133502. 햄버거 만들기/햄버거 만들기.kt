
import java.util.*


class Solution {

    // 1231
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val a = Stack<Int>()
        for (i in ingredient) {
            a.add(i)

            if (a.peek() == 1 && a.size >= 4) {
                val first = a[a.size - 4] == 1
                val second = a[a.size - 3] == 2
                val third = a[a.size - 2] == 3
                val fourth = a[a.size - 1] == 1

                if (first && second && third && fourth) {
                    repeat(4) { a.pop() }
                    answer++
                }

            }
        }
        return answer
    }
}