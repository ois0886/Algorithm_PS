class Solution {
    fun solution(babbling: Array<String>): Int {
        val count : Int
        count = babbling.count {
            it.isNotEmpty() && it.split("aya","ye","woo","ma").none {
                it.isNotEmpty()
            }
        }
        return count
    }
}