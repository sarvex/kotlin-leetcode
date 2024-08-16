internal class Solution {
  private var f: IntArray

  fun minSteps(n: Int): Int {
    f = IntArray(n + 1)
    Arrays.fill(f, -1)
    return dfs(n)
  }

  private fun dfs(n: Int): Int {
    if (n == 1) {
      return 0
    }
    if (f[n] != -1) {
      return f[n]
    }
    var ans = n
    var i = 2
    while (i * i <= n) {
      if (n % i == 0) {
        ans = min(ans, dfs(n / i) + i)
      }
      ++i
    }
    f[n] = ans
    return ans
  }
}
