internal class Solution {
  fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val n = grid.size
    val cnt = IntArray(n * n + 1)
    val ans = IntArray(2)
    for (row in grid) {
      for (x in row) {
        if (++cnt[x] == 2) {
          ans[0] = x
        }
      }
    }
    var x = 1
    while (true) {
      if (cnt[x] == 0) {
        ans[1] = x
        return ans
      }
      ++x
    }
  }
}
