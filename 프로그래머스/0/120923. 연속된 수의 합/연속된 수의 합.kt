class Solution {
    fun solution(num: Int, total: Int): IntArray =
        (total / num - (num - 1) / 2).let { t -> IntArray(num) { index -> index + t } }

}