internal class TicTacToe(private val n: Int) {
  private val cnt = Array(2) { IntArray((n shl 1) + 2) }

  fun move(row: Int, col: Int, player: Int): Int {
    val cur = cnt[player - 1]
    ++cur[row]
    ++cur[n + col]
    if (row == col) {
      ++cur[n shl 1]
    }
    if (row + col == n - 1) {
      ++cur[n shl 1 or 1]
    }
    if (cur[row] == n || cur[n + col] == n || cur[n shl 1] == n || cur[n shl 1 or 1] == n) {
      return player
    }
    return 0
  }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
