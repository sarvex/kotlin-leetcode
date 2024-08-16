internal class Solution {
  fun canMakeSquare(grid: Array<CharArray>): Boolean {
    val dirs = intArrayOf(0, 0, 1, 1, 0)
    for (i in 0..1) {
      for (j in 0..1) {
        var cnt1 = 0
        var cnt2 = 0
        for (k in 0..3) {
          val x = i + dirs[k]
          val y = j + dirs[k + 1]
          cnt1 += if (grid[x][y] == 'W') 1 else 0
          cnt2 += if (grid[x][y] == 'B') 1 else 0
        }
        if (cnt1 != cnt2) {
          return true
        }
      }
    }
    return false
  }
}
