internal class Solution {
  fun minSwaps(grid: Array<IntArray>): Int {
    val n = grid.size
    val pos = IntArray(n)
    Arrays.fill(pos, -1)
    for (i in 0 until n) {
      for (j in n - 1 downTo 0) {
        if (grid[i][j] == 1) {
          pos[i] = j
          break
        }
      }
    }
    var ans = 0
    for (i in 0 until n) {
      var k = -1
      for (j in i until n) {
        if (pos[j] <= i) {
          ans += j - i
          k = j
          break
        }
      }
      if (k == -1) {
        return -1
      }
      while (k > i) {
        val t = pos[k]
        pos[k] = pos[k - 1]
        pos[k - 1] = t
        --k
      }
    }
    return ans
  }
}
