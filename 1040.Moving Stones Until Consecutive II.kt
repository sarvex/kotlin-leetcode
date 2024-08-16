internal class Solution {
  fun numMovesStonesII(stones: IntArray): IntArray {
    Arrays.sort(stones)
    val n = stones.size
    var mi = n
    val mx: Int = max(stones[n - 1] - stones[1] + 1, stones[n - 2] - stones[0] + 1) - (n - 1)
    var i = 0
    var j = 0
    while (j < n) {
      while (stones[j] - stones[i] + 1 > n) {
        ++i
      }
      if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
        mi = min(mi, 2)
      } else {
        mi = min(mi, n - (j - i + 1))
      }
      ++j
    }
    return intArrayOf(mi, mx)
  }
}
