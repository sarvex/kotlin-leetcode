internal class Solution {
  fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
    for (a in -1..1) {
      for (b in -1..1) {
        if (a == 0 && b == 0) {
          continue
        }
        var i = rMove
        var j = cMove
        var cnt = 0
        while (0 <= i + a && i + a < 8 && 0 <= j + b && j + b < 8) {
          i += a
          j += b
          if (++cnt > 1 && board[i][j] == color) {
            return true
          }
          if (board[i][j] == color || board[i][j] == '.') {
            break
          }
        }
      }
    }
    return false
  }
}
