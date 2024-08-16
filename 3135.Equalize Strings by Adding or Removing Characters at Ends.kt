internal class Solution {
  fun minOperations(initial: String, target: String): Int {
    val m = initial.length
    val n = target.length
    val f = Array(m + 1) { IntArray(n + 1) }
    var mx = 0
    for (i in 1..m) {
      for (j in 1..n) {
        if (initial[i - 1] == target[j - 1]) {
          f[i][j] = f[i - 1][j - 1] + 1
          mx = max(mx, f[i][j])
        }
      }
    }
    return m + n - 2 * mx
  }
}
