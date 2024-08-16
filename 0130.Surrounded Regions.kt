internal class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private var board: Array<CharArray>
  private var m = 0
  private var n = 0

  fun solve(board: Array<CharArray>) {
    m = board.size
    n = board[0].size
    this.board = board
    for (i in 0 until m) {
      dfs(i, 0)
      dfs(i, n - 1)
    }
    for (j in 0 until n) {
      dfs(0, j)
      dfs(m - 1, j)
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (board[i][j] == '.') {
          board[i][j] = 'O'
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X'
        }
      }
    }
  }

  private fun dfs(i: Int, j: Int) {
    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
      return
    }
    board[i][j] = '.'
    for (k in 0..3) {
      dfs(i + dirs[k], j + dirs[k + 1])
    }
  }
}
