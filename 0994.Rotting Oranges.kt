import java.util.*

internal class Solution {
  fun orangesRotting(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val q: Deque<IntArray> = ArrayDeque()
    var cnt = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          ++cnt
        } else if (grid[i][j] == 2) {
          q.offer(intArrayOf(i, j))
        }
      }
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    var ans = 0
    while (!q.isEmpty() && cnt > 0) {
      for (k in q.size() downTo 1) {
        val p: Unit = q.poll()
        for (d in 0..3) {
          val x: Int = p.get(0) + dirs[d]
          val y: Int = p.get(1) + dirs[d + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
            grid[x][y] = 2
            q.offer(intArrayOf(x, y))
            --cnt
          }
        }
      }
      ++ans
    }
    return if (cnt > 0) -1 else ans
  }
}
