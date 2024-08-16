internal class Solution {
  fun equalPairs(grid: Array<IntArray>): Int {
    val n = grid.size
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until n) {
        var ok = 1
        for (k in 0 until n) {
          if (grid[i][k] != grid[k][j]) {
            ok = 0
            break
          }
        }
        ans += ok
      }
    }
    return ans
  }
}
