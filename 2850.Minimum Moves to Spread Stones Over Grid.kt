internal class Solution {
  fun minimumMoves(grid: Array<IntArray>): Int {
    val q: Deque<String> = ArrayDeque()
    q.add(f(grid))
    val vis: Set<String> = HashSet()
    vis.add(f(grid))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    var ans = 0
    while (true) {
      for (k in q.size() downTo 1) {
        val p: String = q.poll()
        if ("111111111" == p) {
          return ans
        }
        val cur = g(p)
        for (i in 0..2) {
          for (j in 0..2) {
            if (cur[i][j] > 1) {
              for (d in 0..3) {
                val x = i + dirs[d]
                val y = j + dirs[d + 1]
                if (x >= 0 && x < 3 && y >= 0 && y < 3 && cur[x][y] < 2) {
                  val nxt = Array(3) { IntArray(3) }
                  for (r in 0..2) {
                    for (c in 0..2) {
                      nxt[r][c] = cur[r][c]
                    }
                  }
                  nxt[i][j]--
                  nxt[x][y]++
                  val s = f(nxt)
                  if (!vis.contains(s)) {
                    vis.add(s)
                    q.add(s)
                  }
                }
              }
            }
          }
        }
      }
      ++ans
    }
  }

  private fun f(grid: Array<IntArray>): String {
    val sb = StringBuilder()
    for (row in grid) {
      for (x in row) {
        sb.append(x)
      }
    }
    return sb.toString()
  }

  private fun g(s: String): Array<IntArray> {
    val grid = Array(3) { IntArray(3) }
    for (i in 0..2) {
      for (j in 0..2) {
        grid[i][j] = s[i * 3 + j].code - '0'.code
      }
    }
    return grid
  }
}
