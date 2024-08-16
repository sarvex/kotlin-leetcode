import java.util.*

internal class Solution {
  private val t: Array<String> = arrayOfNulls(6)
  private var board: Array<IntArray>

  fun slidingPuzzle(board: Array<IntArray>): Int {
    this.board = board
    val start = gets()
    val end = "123450"
    if (end == start) {
      return 0
    }
    val vis: Set<String> = HashSet()
    val q: Deque<String> = ArrayDeque()
    q.offer(start)
    vis.add(start)
    var ans = 0
    while (!q.isEmpty()) {
      ++ans
      for (n in q.size() downTo 1) {
        val x = q.poll()
        setb(x)
        for (y in next()) {
          if (y == end) {
            return ans
          }
          if (!vis.contains(y)) {
            vis.add(y)
            q.offer(y)
          }
        }
      }
    }
    return -1
  }

  private fun gets(): String {
    for (i in 0..1) {
      for (j in 0..2) {
        t[i * 3 + j] = board[i][j].toString()
      }
    }
    return java.lang.String.join("", *t)
  }

  private fun setb(s: String) {
    for (i in 0..1) {
      for (j in 0..2) {
        board[i][j] = s[i * 3 + j].code - '0'.code
      }
    }
  }

  private fun find0(): IntArray {
    for (i in 0..1) {
      for (j in 0..2) {
        if (board[i][j] == 0) {
          return intArrayOf(i, j)
        }
      }
    }
    return intArrayOf(0, 0)
  }

  private fun next(): List<String> {
    val p = find0()
    val i = p[0]
    val j = p[1]
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    val res: List<String> = ArrayList()
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < 2 && y >= 0 && y < 3) {
        swap(i, j, x, y)
        res.add(gets())
        swap(i, j, x, y)
      }
    }
    return res
  }

  private fun swap(i: Int, j: Int, x: Int, y: Int) {
    val t = board[i][j]
    board[i][j] = board[x][y]
    board[x][y] = t
  }
}
