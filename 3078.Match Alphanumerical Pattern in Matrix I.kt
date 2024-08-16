import java.util.*

internal class Solution {
  fun findPattern(board: Array<IntArray>, pattern: Array<String>): IntArray {
    val m = board.size
    val n = board[0].size
    val r = pattern.size
    val c = pattern[0].length
    for (i in 0 until m - r + 1) {
      for (j in 0 until n - c + 1) {
        if (check(board, pattern, i, j)) {
          return intArrayOf(i, j)
        }
      }
    }
    return intArrayOf(-1, -1)
  }

  private fun check(board: Array<IntArray>, pattern: Array<String>, i: Int, j: Int): Boolean {
    val d1 = IntArray(26)
    val d2 = IntArray(10)
    Arrays.fill(d1, -1)
    Arrays.fill(d2, -1)
    for (a in pattern.indices) {
      for (b in 0 until pattern[0].length) {
        val x: Int = i + a
        val y: Int = j + b
        if (Character.isDigit(pattern[a][b])) {
          val v: Int = pattern[a][b].code - '0'.code
          if (v != board[x][y]) {
            return false
          }
        } else {
          val v: Int = pattern[a][b].code - 'a'.code
          if (d1[v] != -1 && d1[v] != board[x][y]) {
            return false
          }
          if (d2[board[x][y]] != -1 && d2[board[x][y]] != v) {
            return false
          }
          d1[v] = board[x][y]
          d2[board[x][y]] = v
        }
      }
    }
    return true
  }
}
