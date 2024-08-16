internal class Solution {
  fun candyCrush(board: Array<IntArray>): Array<IntArray> {
    val m = board.size
    val n = board[0].size
    var run = true

    while (run) {
      run = false
      for (i in 0 until m) {
        for (j in 2 until n) {
          if (board[i][j] != 0 && abs(board[i][j]) == abs(board[i][j - 1]) && abs(board[i][j]) == abs(board[i][j - 2])) {
            run = true
            val `val`: Int = abs(board[i][j])
            board[i][j - 2] = -`val`
            board[i][j - 1] = board[i][j - 2]
            board[i][j] = board[i][j - 1]
          }
        }
      }
      for (j in 0 until n) {
        for (i in 2 until m) {
          if (board[i][j] != 0 && abs(board[i][j]) == abs(board[i - 1][j]) && abs(board[i][j]) == abs(board[i - 2][j])) {
            run = true
            val `val`: Int = abs(board[i][j])
            board[i - 2][j] = -`val`
            board[i - 1][j] = board[i - 2][j]
            board[i][j] = board[i - 1][j]
          }
        }
      }
      if (run) {
        for (j in 0 until n) {
          var k = m - 1
          for (i in m - 1 downTo 0) {
            if (board[i][j] > 0) {
              board[k][j] = board[i][j]
              k--
            }
          }
          while (k >= 0) {
            board[k][j] = 0
            k--
          }
        }
      }
    }

    return board
  }
}
