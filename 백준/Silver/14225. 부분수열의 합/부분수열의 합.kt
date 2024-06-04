import java.io.*
import java.util.*

private lateinit var input: List<Int>
private val visited = BooleanArray(2000001)
private val graph = BooleanArray(2000001)

private fun combination(result: Int, idx: Int, n: Int) {

    graph[result] = true

    for (i in idx until n) {
        if (visited[i]) continue
        visited[i] = true
        combination(result + input[i], i + 1, n)
        visited[i] = false
    }
}

fun main(args: Array<String>) = with(System.out.bufferedWriter()) {
    //input
    val br = System.`in`.bufferedReader()

    fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }
    fun getInt() = br.readLine().toInt()
    val n = getInt()
    input = getIntGraph()

    //solve
    combination(0, 0, n)

    //output
    for (i in graph.indices) {
        if (!graph[i]) {
            write("$i")
            close()
            return
        }
    }

    close()
}
