internal class Solution {
  private var f: Array<Int>
  private var s: IntArray
  private var n = 0

  fun stoneGameVIII(stones: IntArray): Int {
    n = stones.size
    f = arrayOfNulls(n)
    for (i in 1 until n) {
      stones[i] += stones[i - 1]
    }
    s = stones
    return dfs(1)
  }

  private fun dfs(i: Int): Int {
    if (i >= n - 1) {
      return s[i]
    }
    if (f[i] == null) {
      f[i] = max(dfs(i + 1), s[i] - dfs(i + 1))
    }
    return f[i]
  }
}
