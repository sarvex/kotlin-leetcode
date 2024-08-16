internal class Solution {
  private var n = 0
  private var root = 0
  private var cnt: IntArray
  private var p: Array<IntArray>
  private var grid: Array<IntArray>
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)

  fun largestIsland(grid: Array<IntArray>): Int {
    n = grid.size
    p = Array(n) { IntArray(n) }
    this.grid = grid
    cnt = IntArray(n * n + 1)
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] == 1 && p[i][j] == 0) {
          ++root
          ans = max(ans, dfs(i, j))
        }
      }
    }
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] == 0) {
          val s: Set<Int> = HashSet()
          for (k in 0..3) {
            val x: Int = i + dirs[k]
            val y: Int = j + dirs[k + 1]
            if (x >= 0 && x < n && y >= 0 && y < n) {
              s.add(p[x][y])
            }
          }
          var t = 1
          for (x in s) {
            t += cnt[x]
          }
          ans = max(ans, t)
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    p[i][j] = root
    ++cnt[root]
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1 && p[x][y] == 0) {
        dfs(x, y)
      }
    }
    return cnt[root]
  }
}
