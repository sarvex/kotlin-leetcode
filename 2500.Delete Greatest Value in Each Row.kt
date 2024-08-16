import java.util.*

internal class Solution {
  fun deleteGreatestValue(grid: Array<IntArray>): Int {
    for (row in grid) {
      Arrays.sort(row)
    }
    var ans = 0
    for (j in grid[0].indices) {
      var t = 0
      for (i in grid.indices) {
        t = max(t, grid[i][j])
      }
      ans += t
    }
    return ans
  }
}
