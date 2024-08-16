import java.util.*

internal class Solution {
  fun snakesAndLadders(board: Array<IntArray>): Int {
    val n = board.size
    val q: Deque<Int> = ArrayDeque()
    q.offer(1)
    val m = n * n
    val vis = BooleanArray(m + 1)
    vis[1] = true
    var ans = 0
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val x = q.poll()
        if (x == m) {
          return ans
        }
        for (y in x + 1..min(x + 6, m)) {
          var i = (y - 1) / n
          var j = (y - 1) % n
          if (i % 2 == 1) {
            j = n - j - 1
          }
          i = n - i - 1
          val z = if (board[i][j] == -1) y else board[i][j]
          if (!vis[z]) {
            vis[z] = true
            q.offer(z)
          }
        }
      }
      ++ans
    }
    return -1
  }
}
