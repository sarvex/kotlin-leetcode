internal class Solution {
  private var n = 0
  private var f: Array<Int>

  fun selfDivisiblePermutationCount(n: Int): Int {
    this.n = n
    f = arrayOfNulls(1 shl (n + 1))
    return dfs(0)
  }

  private fun dfs(mask: Int): Int {
    if (f[mask] != null) {
      return f[mask]
    }
    val i = Integer.bitCount(mask) + 1
    if (i > n) {
      return 1
    }
    f[mask] = 0
    for (j in 1..n) {
      if ((mask shr j and 1) == 0 && (i % j == 0 || j % i == 0)) {
        f[mask] += dfs(mask or (1 shl j))
      }
    }
    return f[mask]
  }
}
