class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        val checkList = arrayOf<String>("aya", "ye", "woo", "ma")
        for(check in babbling){
            var temp = check
            for(i in 0 .. checkList.size-1){
                if(temp.contains(checkList[i]+checkList[i])){
                    continue
                } else {
                    temp = temp.replace(checkList[i], " ")
                }
            }
            if(temp.replace(" ","") == "") answer++
        }
        return answer
    }
}