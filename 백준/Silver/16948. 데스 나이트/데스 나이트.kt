package baekjoon.kotlin.test

import java.io.*
import java.util.*


object Main {
    private lateinit var grid: Array<IntArray>
    private var dx = intArrayOf(-1, 1, -2, 2, -1, 1)
    private var dy = intArrayOf(-2, -2, 0, 0, 2, 2)
    private lateinit var visited: Array<BooleanArray>
    private var end: Pos? = null

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val size = br.readLine().toInt()
        grid = Array(size) { IntArray(size) }
        visited = Array(size) { BooleanArray(size) }
        val st = StringTokenizer(br.readLine())
        val start = Pos(st.nextToken().toInt(), st.nextToken().toInt())
        end = Pos(st.nextToken().toInt(), st.nextToken().toInt())
        bfs(start)
    }

    private fun bfs(start: Pos) {
        val queue: Queue<Pos> = LinkedList()
        queue.add(start)
        visited[start.y][start.x] = true
        while (!queue.isEmpty()) {
            val cur = queue.poll()
            for (i in 0..5) {
                val nextX = cur.x + dx[i]
                val nextY = cur.y + dy[i]
                if (nextX >= 0 && nextX < grid.size && nextY >= 0 && nextY < grid.size && !visited[nextY][nextX]) {
                    if (nextX == end!!.x && nextY == end!!.y) {
                        println(grid[cur.y][cur.x] + 1)
                        return
                    }
                    visited[nextY][nextX] = true
                    queue.add(Pos(nextY, nextX))
                    grid[nextY][nextX] = grid[cur.y][cur.x] + 1
                }
            }
        }
        println("-1")
    }
}


class Pos(var y: Int, var x: Int)