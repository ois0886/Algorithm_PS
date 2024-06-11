import java.io.*
import java.lang.StringBuilder
import kotlin.math.max

var t = 0
lateinit var array: IntArray
lateinit var cache: Array<IntArray>


fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    t = readLine().toInt()

    val sb = StringBuilder()
    var max = 3
    array = IntArray(t) {
        readLine().toInt().also {
            max = max(max, it)
        }
    }
    cache = Array(max + 1) { IntArray(4) }.apply {
        this[1][1] = 1
        this[2][1] = 1
        this[2][2] = 1
        this[3][1] = 1
        this[3][2] = 1
        this[3][3] = 1
    }

    for (i in 4 until cache.size) {
        cache[i][1] = cache[i - 1][1]
        cache[i][2] = cache[i - 2][1] + cache[i - 2][2]
        cache[i][3] = cache[i - 3][1] + cache[i - 3][2] + cache[i - 3][3]
    }

    array.forEach {
        sb.append("${cache[it].sum()}\n")
    }
    println(sb)

}
